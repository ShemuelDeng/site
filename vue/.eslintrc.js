module.exports = {
    'env': {
        'browser': true,
        'es6': true
    },
    'extends': [
        'standard',
        'plugin:vue/base',
        'plugin:vue/essential',
        'plugin:vue/strongly-recommended',
        'plugin:vue/recommended'
    ],
    'parserOptions': {
        'parser': 'babel-eslint',
        'ecmaVersion': 6
    },
    'rules': {
        'indent': [
            'error',
            4,
            {
                'VariableDeclarator': 2,
                'MemberExpression': 2
            }
        ],
        'vue/html-indent': ['error', 4, {
            'attribute': 1,
            'baseIndent': 1,
            'closeBracket': 0,
            'alignAttributesVertically': true,
            'ignores': []
        }],
        'vue/script-indent': ['error', 4, {
            'baseIndent': 1,
            'switchCase': 1,
            'ignores': []
        }],
        'vue/html-self-closing': 0,
        'semi': ['error', 'always'],
        'no-fallthrough': 0,
        'no-debugger': 0,
        'prefer-promise-reject-errors': ['error', { 'allowEmptyReject': true }],
        'import/no-duplicates': 0
    },
    'overrides': [
        {
            'files': ['*.vue'],
            'rules': {
                'indent': 'off'
            }
        }
    ]
};
