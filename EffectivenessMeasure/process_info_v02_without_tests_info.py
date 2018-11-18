# v.02

from sympy import *
from sympy.parsing.sympy_parser import parse_expr

def conf2uniquestr(conf_dict):

	actives = []

	for feature in conf_dict.keys():
		if conf_dict[feature]:
			actives.append(feature.__repr__())

	actives.sort()
	return actives.__repr__()

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
			confs_str.add(conf2uniquestr(c))
			# print c

	return confs_str

def analyse(features, feature_model, exprs):

	fm_features = feature_model.atoms()
	diff_optional_features = list(features.difference(fm_features))

	if len(diff_optional_features) > 0:
		print 'More features besides FM:', diff_optional_features

		opt_expr = diff_optional_features[0] | Not(diff_optional_features[0])

		for i in range(1, len(diff_optional_features)):
			opt_expr = opt_expr | diff_optional_features[i] | Not(diff_optional_features[i])

		feature_model = (feature_model) & (opt_expr)

	print 'FM:', feature_model
	all_confs = all_valid_products(feature_model)
	print 'Max possible products:', len(all_confs)

	confs_fail = set()
	for expr in exprs:
		confs = all_valid_products(feature_model, expr)
		confs_fail.update(confs)
		print 'Products failed by', expr, ':', len(confs)
		# print confs

	print 'Total failed products:', len(confs_fail)
