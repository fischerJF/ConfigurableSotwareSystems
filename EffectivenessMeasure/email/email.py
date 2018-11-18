#execfile('../process_info.py')
execfile('process_info.py') #../


#base is mandatory
email_features_str = 'KEYS ENCRYPT AUTORESPONDER ADDRESSBOOK SIGN FORWARD VERIFY DECRYPT'

email_features = features_set(email_features_str)

email_fm = parse_expr('(~ENCRYPT | DECRYPT) & (~DECRYPT | ENCRYPT) & (~ENCRYPT | KEYS) & (~SIGN | VERIFY) & (~VERIFY | SIGN) & (~SIGN | KEYS)')

file_lines = readlines('email/result_varexj_input.txt')
email_varexj_pairs = parse_varexj_lines(file_lines)
file_lines = readlines('email/result_splat_input.txt')
email_splat_pairs = parse_splat_lines(file_lines)

analyse(email_features, email_fm, email_varexj_pairs, email_splat_pairs)
