# v.01

from sympy import *
from sympy.parsing.sympy_parser import parse_expr

# def valid_product(fm, conf):
# 	return satisfiable(fm & conf)

def features_set(features_str):
	features = set()
	for s in features_str.split():
		features.add(Symbol(s))
	return features

def all_valid_products(fm, conf_expr=None):
	if conf_expr is None:
		confs = satisfiable(fm, all_models=True)
	else:
		confs = satisfiable((conf_expr) & (fm), all_models=True)
	
	qtd_confs = 0
	for c in confs:
		# print c
		qtd_confs += 1
	return qtd_confs

def analyse(features, feature_model, varexj_exprs):

	fm = feature_model
	fm_features = fm.atoms()
	diff_optional_features = list(features.difference(fm_features))

	if len(diff_optional_features) > 0:
		print 'More features besides FM:', diff_optional_features

		opt_expr = diff_optional_features[0] | Not(diff_optional_features[0])

		for i in range(1, len(diff_optional_features)):
			opt_expr = opt_expr | diff_optional_features[i] | Not(diff_optional_features[i])

		fm = (fm) & (opt_expr)

	print 'FM:', fm
	all_confs = all_valid_products(fm)
	print 'All possible products:', all_confs

	total_confs = 0
	for expr in varexj_exprs:
		confs = all_valid_products(fm, expr)
		total_confs += confs
		print confs, 'products failed by', expr

	print 'Total failed products:', total_confs
