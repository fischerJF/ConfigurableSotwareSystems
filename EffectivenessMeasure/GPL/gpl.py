# execfile('../process_info.py')
execfile('process_info.py') #../


#BASE is mandatory
gpl_features_str = 'DIRECTED UNDIRECTED WEIGHTED SEARCH BFS NUMBER CONNECTED STRONGLYCONNECTED CYCLE MSTPRIM MSTKRUSKAL SHORTEST DFS'

gpl_features = features_set(gpl_features_str)

gpl_fm = parse_expr('(SEARCH | ~BFS) & (SEARCH | ~DFS) & (~BFS | ~DFS) & (BFS | DFS | ~SEARCH) & (DIRECTED | UNDIRECTED) & (~DIRECTED | ~UNDIRECTED) & (~NUMBER | SEARCH | ~BFS) & (~NUMBER | SEARCH | ~DFS) & (~NUMBER | ~BFS | ~DFS) & (~NUMBER | BFS | DFS | ~SEARCH) & (~CONNECTED | UNDIRECTED) & (~CONNECTED | SEARCH | ~BFS) & (~CONNECTED | SEARCH | ~DFS) & (~CONNECTED | ~BFS | ~DFS) & (~CONNECTED | BFS | DFS | ~SEARCH) & (~STRONGLYCONNECTED | DIRECTED) & (~STRONGLYCONNECTED | DFS) & (~CYCLE | DFS)  & (~MSTKRUSKAL | UNDIRECTED) & (~MSTPRIM | UNDIRECTED) & (~MSTKRUSKAL | WEIGHTED) & (~MSTPRIM | WEIGHTED) & (~MSTKRUSKAL | ~MSTPRIM | ~MSTKRUSKAL) & (~MSTKRUSKAL | ~MSTPRIM | ~MSTPRIM) & (~SHORTEST | DIRECTED) & (~SHORTEST | WEIGHTED)')
gpl_fm = parse_expr('~DFS') & gpl_fm #DFS never used in source code


file_lines = readlines('GPL/result_varexj_input.txt')
gpl_varexj_pairs = parse_varexj_lines(file_lines)
# gpl_varexj_pairs = list()
file_lines = readlines('GPL/result_splat_input.txt')
gpl_splat_pairs = parse_splat_lines(file_lines)


analyse(gpl_features, gpl_fm, gpl_varexj_pairs, gpl_splat_pairs)
