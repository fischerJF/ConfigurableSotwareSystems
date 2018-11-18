# v.03

from sympy import *
from sympy.parsing.sympy_parser import parse_expr

def readlines(path_to_file):
	lines = list()

	file = open(path_to_file, 'r')
	for line in file: 
		lines.append(line.strip()) #due to Windows
	file.close()

	return lines


def save_results(output_file, content):
	file = open(output_file, 'w')

	file.write('\t'.join(['Test', 'Confs. (features enabled)'])) #header
	file.write('\n')

	for data in content:
		if type(data) is tuple:
			file.write('\t'.join(data))
		else:
			file.write(data.replace(', ', '\t'))
		file.write('\n')

	file.close()	


def conf2uniquestr(conf_dict):
	actives = []

	for feature in conf_dict.keys():
		if conf_dict[feature]:
			actives.append(feature.__repr__())

	actives.sort()
	return ', '.join(actives)


def features_set(features_str):
	features = set()
	for s in features_str.split():
		features.add(Symbol(s))
	return features

# def valid_product(fm, conf):
# 	return satisfiable(fm & conf)
def all_valid_products(fm, conf_expr=None):
	if conf_expr is None:
		confs = satisfiable(fm, all_models=True)
	else:
		confs = satisfiable((conf_expr) & (fm), all_models=True)
	
	confs_str = set()

	for c in confs:
		if c:
			confs_str.add(conf2uniquestr(c)) #it CAN be '' (all features disabled)
			# print c
	return confs_str


def parse_varexj_lines(lines):

	pairs = list() #list of tuples of test info (including line) and expression

	for line in lines: 
		items = line.split()

		expr_content = items[1]
		expr = parse_expr(expr_content.replace('!', '~').replace(':', ''))

		test_info = items[3]
		pairs.append(tuple([test_info, expr]))
		# print test_info, expr_content,

	return pairs


def parse_splat_lines(lines):

	pairs = list() #list of tuples of test info (including line) and expression

	for line in lines: 
		items = line.split('\t')

		conf_content = items[0].replace('!', '~')
		conf_items = conf_content.split(', ')

		expr = None
		for conf_item in conf_items:
			if conf_item == '?' or conf_item == 'F' or conf_item == 'BASE': #TODO REVIEW for each SPL (TREE_STRUCTURE, BASE, etc)
				continue
			
			tmp = parse_expr(conf_item)
			expr = tmp if expr is None else expr & tmp

		test_info = items[1][3:]
		pairs.append(tuple([test_info, expr]))

	return pairs


def confs_from_exprs(feature_model, tests_and_exprs):

	tests_and_confs = set() #set of tuples of test info and configurations

	for pair in tests_and_exprs:
		expr = pair[1]
		confs = all_valid_products(feature_model, expr)
		# print 'Products failed by', expr, ':', len(confs)

		test = pair[0]

		# if test.endswith('(MultiFeatureTest_Caio.java:38)'):
		# 	print test
		# 	print expr
		# 	print confs

		for conf in confs:
			tt = tuple([test, conf])
			tests_and_confs.add(tt)

	return tests_and_confs


def analyse(features, feature_model_original, varexj_exprs, splat_exprs):

	feature_model = feature_model_original
	fm_features = feature_model_original.atoms()
	diff_optional_features = list(features.difference(fm_features))

	if len(diff_optional_features) > 0:
		print 'More features besides FM:', diff_optional_features

		opt_expr = diff_optional_features[0] | Not(diff_optional_features[0])

		for i in range(1, len(diff_optional_features)):
			opt_expr = opt_expr | diff_optional_features[i] | Not(diff_optional_features[i])

		feature_model = (feature_model_original) & (opt_expr)

	print 'Feature Model:', feature_model
	all_confs = all_valid_products(feature_model)

	print 'Max possible products:', len(all_confs), '\n'
	# print all_confs

	failure_pairs_varexj = confs_from_exprs(feature_model, varexj_exprs)
	failure_pairs_splat = confs_from_exprs(feature_model, splat_exprs)
	intersection = failure_pairs_varexj.intersection(failure_pairs_splat)
	diff_varexj_splat = failure_pairs_varexj.difference(failure_pairs_splat)
	diff_splat_varexj = failure_pairs_splat.difference(failure_pairs_varexj)

	print 'Total failure pairs by VarexJ:', len(failure_pairs_varexj)
	print 'Total failure pairs by SPLat:', len(failure_pairs_splat)
	print 'Intersection between VarexJ and SPLat:', len(intersection)
	print 'Failure pairs by VarexJ and not by SPLat:', len(diff_varexj_splat)
	print 'Failure pairs by SPLat and not by VarexJ:', len(diff_splat_varexj)

	root_dir_old = '/Users/ti/Desktop/'
	save_results('/home/jpaulo/Desktop/temp/ALL_VALID_CONFS.csv', all_confs)
	save_results('/home/jpaulo/Desktop/temp/FAILURE_PAIRS_SPLAT.csv', failure_pairs_splat)
	save_results('/home/jpaulo/Desktop/temp/FAILURE_PAIRS_VAREXJ.csv', failure_pairs_varexj)
	save_results('/home/jpaulo/Desktop/temp/CONFS_INTERSECTION.csv', intersection)
	save_results('/home/jpaulo/Desktop/temp/DIFF_VAREXJ_SPLAT.csv', diff_varexj_splat)
	save_results('/home/jpaulo/Desktop/temp/DIFF_SPLAT_VAREXJ.csv', diff_splat_varexj)

	# print '\nVarexJ:'
	# for cf in failure_pairs_varexj:
	# 	print cf[0], cf[1]

	# print '\nSPLat:'
	# for cf in failure_pairs_splat:
	# 	print cf[0]#, cf[1]
