execfile('process_info.py')

#TREE_STRUCTURE is mandatory
companies_features_str = 'LOGGING CUT_WHATEVER CUT_NO_DEPARTMENT CUT_NO_MANAGER GUI PRECEDENCE TOTAL_WALKER TOTAL_REDUCER ACCESS_CONTROL'

companies_features = features_set(companies_features_str)

companies_fm = parse_expr('(~CUT_WHATEVER | ~CUT_NO_DEPARTMENT | ~CUT_NO_MANAGER) & (~CUT_WHATEVER | ~CUT_NO_DEPARTMENT) & (~CUT_WHATEVER | ~CUT_NO_MANAGER) & (~CUT_NO_DEPARTMENT | ~CUT_NO_MANAGER) & (~TOTAL_WALKER | ~TOTAL_REDUCER)')

companies_varexj_exprs = list()

file_lines = readlines('Companies/result_varexj_input.txt')
companies_varexj_pairs = parse_varexj_lines(file_lines)
# companies_varexj_pairs = list()
file_lines = readlines('Companies/result_splat_input.txt')
companies_splat_pairs = parse_splat_lines(file_lines)

analyse(companies_features, companies_fm, companies_varexj_pairs, companies_splat_pairs)
