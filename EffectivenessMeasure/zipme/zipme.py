execfile('process_info.py')

#BASE is mandatory
#COMPRESS is mandatory
zipme_features_str = 'COMPRESS GZIP EXTRACT ARCHIVECHECK CRC ADLER32CHECKSUM DERIVATIVE_COMPRESS_ADLER32CHECKSUM DERIVATIVE_COMPRESS_CRC DERIVATIVE_COMPRESS_GZIP DERIVATIVE_COMPRESS_GZIPCRC DERIVATIVE_EXTRACT_CRC DERIVATIVE_GZIPCRC'

zipme_features = features_set(zipme_features_str)

zipme_fm = parse_expr('(~GZIP | CRC) & (~COMPRESS | ~ADLER32CHECKSUM | DERIVATIVE_COMPRESS_ADLER32CHECKSUM) & (~DERIVATIVE_COMPRESS_ADLER32CHECKSUM | COMPRESS) & (~DERIVATIVE_COMPRESS_ADLER32CHECKSUM | ADLER32CHECKSUM) & (~COMPRESS | ~CRC | DERIVATIVE_COMPRESS_CRC) & (~DERIVATIVE_COMPRESS_CRC | COMPRESS) & (~DERIVATIVE_COMPRESS_CRC | CRC) & (~COMPRESS | ~GZIP | DERIVATIVE_COMPRESS_GZIP) & (~DERIVATIVE_COMPRESS_GZIP | COMPRESS) & (~DERIVATIVE_COMPRESS_GZIP | GZIP) & (~COMPRESS | ~GZIP | ~CRC | DERIVATIVE_COMPRESS_GZIPCRC) & (~DERIVATIVE_COMPRESS_GZIPCRC | COMPRESS) & (~DERIVATIVE_COMPRESS_GZIPCRC | GZIP) & (~DERIVATIVE_COMPRESS_GZIPCRC | CRC) & (~EXTRACT | ~CRC | DERIVATIVE_EXTRACT_CRC) & (~DERIVATIVE_EXTRACT_CRC | EXTRACT) & (~DERIVATIVE_EXTRACT_CRC | CRC) & (~GZIP | ~CRC | DERIVATIVE_GZIPCRC) & (~DERIVATIVE_GZIPCRC | GZIP) & (~DERIVATIVE_GZIPCRC | CRC)')
# zipme_fm = parse_expr('BASE & COMPRESS') & zipme_fm # COMPRESS is mandatory

file_lines = readlines('zipme/result_varexj_input.txt')
zipme_varexj_pairs = parse_varexj_lines(file_lines)
# zipme_varexj_exprs = list()

file_lines = readlines('zipme/result_splat_input.txt')
zipme_splat_pairs = parse_splat_lines(file_lines)
# zipme_splat_pairs = list()


analyse(zipme_features, zipme_fm, zipme_varexj_pairs, zipme_splat_pairs)
