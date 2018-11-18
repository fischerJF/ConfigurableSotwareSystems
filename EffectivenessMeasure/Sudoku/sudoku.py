execfile('process_info.py')


#BASE is mandatory
sudoku_features_str = 'STATES UNDO COLOR SOLVER GENERATOR EXTENDEDSUDOKU'

sudoku_features = features_set(sudoku_features_str)

sudoku_fm = parse_expr('(~UNDO | STATES) & (~GENERATOR | SOLVER) & (~SOLVER | UNDO)')


file_lines = readlines('Sudoku/result_varexj_input.txt')
sudoku_varexj_pairs = parse_varexj_lines(file_lines)
# sudoku_varexj_pairs = list()
file_lines = readlines('Sudoku/result_splat_input.txt')
sudoku_splat_pairs = parse_splat_lines(file_lines)


analyse(sudoku_features, sudoku_fm, sudoku_varexj_pairs, sudoku_splat_pairs)

