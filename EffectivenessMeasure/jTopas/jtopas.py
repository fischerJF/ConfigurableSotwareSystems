#execfile('../process_info.py')
execfile('process_info.py') #../


#BASE is mandatory
jtopas_features_str = 'IMAGEPARTS TOKENPOSONLY COUNTLINES BLOCKCOMMENTS LINECOMMENTS'

jtopas_features = features_set(jtopas_features_str)

# all optional
jtopas_fm = parse_expr('IMAGEPARTS | TOKENPOSONLY | COUNTLINES | BLOCKCOMMENTS | LINECOMMENTS | ~IMAGEPARTS | ~TOKENPOSONLY | ~COUNTLINES | ~BLOCKCOMMENTS | ~LINECOMMENTS')

file_lines = readlines('jTopas/result_varexj_input.txt')
jtopas_varexj_pairs = parse_varexj_lines(file_lines)
file_lines = readlines('jTopas/result_splat_input.txt')
jtopas_splat_pairs = parse_splat_lines(file_lines)

analyse(jtopas_features, jtopas_fm, jtopas_varexj_pairs, jtopas_splat_pairs)
