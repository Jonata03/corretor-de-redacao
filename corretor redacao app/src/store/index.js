import {createStore} from 'vuex'

const store = createStore({
    state: {
        myState: 'valorInicial',
        temasRedacao: [
            /*{
                titulo: 'Tema Livre',
                imagem: '',
                textosMotivadores: [
                    {
                        titulo: 'Tema Livre',
                        imagem: '',
                        texto: 'Sinta-se à vontade para escrever sobre um tema qualquer',
                        fonte: ''
                    },
                ]
            },*/
            {
                titulo: 'Desafios para a valorização da herança africana no Brasil',
                imagem: './src/assets/images/img-tema-1.jpg',
                textosMotivadores: [
                    {
                        titulo: '',
                        imagem:'./src/assets/images/img-tema-1.jpg',
                        texto: ' Herança – o legado de crenças, conhecimentos, técnicas, costumes, tradições, transmitido por um grupo social de geração para geração; cultura.',
                        fonte: 'HOUAISS, A.; VILLAR, M. S. Dicionário Houaiss da língua portuguesa. Rio de Janeiro: Objetiva, 2009 (adaptado).'
                    },
                    {
                        titulo: '',
                        imagem: '',
                        texto: 'As culturas africanas e afro-brasileiras foram relegadas ao campo do folclore com o propósito de confiná-las ao gueto fossilizado da memória. Folclorizar, nesse caso, é reduzir uma cultura a um conjunto de representações estereotipadas, via de regra, alheias ao contexto que produziu essa cultura.',
                        fonte: 'OLIVEIRA, E. D. A epistemologia da ancestralidade. Entrelugares: revista de sociopoética e abordagens afins, 2009.'
                    },
                    {
                        titulo: ' História afro-brasileira nas escolas: professoras comentam avanços e dificuldades',
                        imagem: '',
                        texto: ' As aulas sobre escravidão eram motivo de vergonha para uma professora quando ela estudava em uma escola municipal na zona sul de São Paulo. “Era o meu pior momento na escola”, lembra a ex-aluna. Naquela época, a história da população negra no Brasil era reduzida ao horror do período escravocrata. Não se falava na escola sobre temas como a história e a cultura afro-brasileira, muito menos sobre as grandes personalidades negras do país, como Luiz Gama e Carolina Maria de Jesus.\n' +
                            'A pedagoga, que é negra, tem orgulho de oferecer uma experiência diferente da que viveu em sala de aula para seus alunos. Agora os livros infantis levados para a turmas têm protagonistas pretos. Temas como a beleza do cabelo crespo e o combate ao racismo fazem parte do dia a dia da escola.',
                        fonte: 'Disponível em: https://jornal.unesp.br.Acesso em: 3 jun. 2024 (adaptado).'
                    },
                    {
                        titulo: 'Histórias para ninar gente grande',
                        imagem: '',
                        texto: ' Brasil, meu nego\n' +
                            ' Deixa eu te contar\n' +
                            ' A história que a história não conta\n' +
                            ' O avesso do mesmo lugar\n' +
                            ' Na luta é que a gente se encontra\n' +
                            ' Brasil, meu dengo\n' +
                            ' A Mangueira chegou\n' +
                            ' Com versos que o livro apagou\n' +
                            ' Desde 1500 tem mais invasão do que descobrimento\n' +
                            ' Tem sangue retinto pisado\n' +
                            ' Atrás do herói emoldurado\n' +
                            ' Mulheres, tamoios, mulatos\n' +
                            ' Eu quero um país que não está no retrato\n' +
                            ' Brasil, o teu nome é Dandara\n' +
                            ' E a tua cara é de cariri\n' +
                            ' Não veio do céu\n' +
                            ' Nem das mãos de Isabel\n' +
                            ' A liberdade é um dragão no mar de Aracati\n' +
                            ' Salve os caboclos de julho\n' +
                            ' Quem foi de aço nos anos de chumbo\n' +
                            ' Brasil, chegou a vez\n' +
                            ' De ouvir as Marias, Mahins, Marielles, malês',
                        fonte: 'Disponível em: www.mangueira.com.br.\n' +
                            'Acesso em: 30 maio 2024 (fragmento).'
                    },
                ]
            },
            {
                titulo: 'Desafios para a valorização da herança africana no Brasil',
                imagem: './src/assets/images/img-tema-1.jpg',
                textosMotivadores: [
                    {
                        titulo: '',
                        imagem:'./src/assets/images/img-tema-1.jpg',
                        texto: ' Herança – o legado de crenças, conhecimentos, técnicas, costumes, tradições, transmitido por um grupo social de geração para geração; cultura.',
                        fonte: 'HOUAISS, A.; VILLAR, M. S. Dicionário Houaiss da língua portuguesa. Rio de Janeiro: Objetiva, 2009 (adaptado).'
                    },
                    {
                        titulo: '',
                        imagem: '',
                        texto: 'As culturas africanas e afro-brasileiras foram relegadas ao campo do folclore com o propósito de confiná-las ao gueto fossilizado da memória. Folclorizar, nesse caso, é reduzir uma cultura a um conjunto de representações estereotipadas, via de regra, alheias ao contexto que produziu essa cultura.',
                        fonte: 'OLIVEIRA, E. D. A epistemologia da ancestralidade. Entrelugares: revista de sociopoética e abordagens afins, 2009.'
                    },
                    {
                        titulo: ' História afro-brasileira nas escolas: professoras comentam avanços e dificuldades',
                        imagem: '',
                        texto: ' As aulas sobre escravidão eram motivo de vergonha para uma professora quando ela estudava em uma escola municipal na zona sul de São Paulo. “Era o meu pior momento na escola”, lembra a ex-aluna. Naquela época, a história da população negra no Brasil era reduzida ao horror do período escravocrata. Não se falava na escola sobre temas como a história e a cultura afro-brasileira, muito menos sobre as grandes personalidades negras do país, como Luiz Gama e Carolina Maria de Jesus.\n' +
                            'A pedagoga, que é negra, tem orgulho de oferecer uma experiência diferente da que viveu em sala de aula para seus alunos. Agora os livros infantis levados para a turmas têm protagonistas pretos. Temas como a beleza do cabelo crespo e o combate ao racismo fazem parte do dia a dia da escola.',
                        fonte: 'Disponível em: https://jornal.unesp.br.Acesso em: 3 jun. 2024 (adaptado).'
                    },
                    {
                        titulo: 'Histórias para ninar gente grande',
                        imagem: '',
                        texto: ' Brasil, meu nego\n' +
                            ' Deixa eu te contar\n' +
                            ' A história que a história não conta\n' +
                            ' O avesso do mesmo lugar\n' +
                            ' Na luta é que a gente se encontra\n' +
                            ' Brasil, meu dengo\n' +
                            ' A Mangueira chegou\n' +
                            ' Com versos que o livro apagou\n' +
                            ' Desde 1500 tem mais invasão do que descobrimento\n' +
                            ' Tem sangue retinto pisado\n' +
                            ' Atrás do herói emoldurado\n' +
                            ' Mulheres, tamoios, mulatos\n' +
                            ' Eu quero um país que não está no retrato\n' +
                            ' Brasil, o teu nome é Dandara\n' +
                            ' E a tua cara é de cariri\n' +
                            ' Não veio do céu\n' +
                            ' Nem das mãos de Isabel\n' +
                            ' A liberdade é um dragão no mar de Aracati\n' +
                            ' Salve os caboclos de julho\n' +
                            ' Quem foi de aço nos anos de chumbo\n' +
                            ' Brasil, chegou a vez\n' +
                            ' De ouvir as Marias, Mahins, Marielles, malês',
                        fonte: 'Disponível em: www.mangueira.com.br.\n' +
                            'Acesso em: 30 maio 2024 (fragmento).'
                    },
                ]
            },
            {
                titulo: 'Desafios para a valorização da herança africana no Brasil',
                imagem: './src/assets/images/img-tema-1.jpg',
                textosMotivadores: [
                    {
                        titulo: '',
                        imagem:'./src/assets/images/img-tema-1.jpg',
                        texto: ' Herança – o legado de crenças, conhecimentos, técnicas, costumes, tradições, transmitido por um grupo social de geração para geração; cultura.',
                        fonte: 'HOUAISS, A.; VILLAR, M. S. Dicionário Houaiss da língua portuguesa. Rio de Janeiro: Objetiva, 2009 (adaptado).'
                    },
                    {
                        titulo: '',
                        imagem: '',
                        texto: 'As culturas africanas e afro-brasileiras foram relegadas ao campo do folclore com o propósito de confiná-las ao gueto fossilizado da memória. Folclorizar, nesse caso, é reduzir uma cultura a um conjunto de representações estereotipadas, via de regra, alheias ao contexto que produziu essa cultura.',
                        fonte: 'OLIVEIRA, E. D. A epistemologia da ancestralidade. Entrelugares: revista de sociopoética e abordagens afins, 2009.'
                    },
                    {
                        titulo: ' História afro-brasileira nas escolas: professoras comentam avanços e dificuldades',
                        imagem: '',
                        texto: ' As aulas sobre escravidão eram motivo de vergonha para uma professora quando ela estudava em uma escola municipal na zona sul de São Paulo. “Era o meu pior momento na escola”, lembra a ex-aluna. Naquela época, a história da população negra no Brasil era reduzida ao horror do período escravocrata. Não se falava na escola sobre temas como a história e a cultura afro-brasileira, muito menos sobre as grandes personalidades negras do país, como Luiz Gama e Carolina Maria de Jesus.\n' +
                            'A pedagoga, que é negra, tem orgulho de oferecer uma experiência diferente da que viveu em sala de aula para seus alunos. Agora os livros infantis levados para a turmas têm protagonistas pretos. Temas como a beleza do cabelo crespo e o combate ao racismo fazem parte do dia a dia da escola.',
                        fonte: 'Disponível em: https://jornal.unesp.br.Acesso em: 3 jun. 2024 (adaptado).'
                    },
                    {
                        titulo: 'Histórias para ninar gente grande',
                        imagem: '',
                        texto: ' Brasil, meu nego\n' +
                            ' Deixa eu te contar\n' +
                            ' A história que a história não conta\n' +
                            ' O avesso do mesmo lugar\n' +
                            ' Na luta é que a gente se encontra\n' +
                            ' Brasil, meu dengo\n' +
                            ' A Mangueira chegou\n' +
                            ' Com versos que o livro apagou\n' +
                            ' Desde 1500 tem mais invasão do que descobrimento\n' +
                            ' Tem sangue retinto pisado\n' +
                            ' Atrás do herói emoldurado\n' +
                            ' Mulheres, tamoios, mulatos\n' +
                            ' Eu quero um país que não está no retrato\n' +
                            ' Brasil, o teu nome é Dandara\n' +
                            ' E a tua cara é de cariri\n' +
                            ' Não veio do céu\n' +
                            ' Nem das mãos de Isabel\n' +
                            ' A liberdade é um dragão no mar de Aracati\n' +
                            ' Salve os caboclos de julho\n' +
                            ' Quem foi de aço nos anos de chumbo\n' +
                            ' Brasil, chegou a vez\n' +
                            ' De ouvir as Marias, Mahins, Marielles, malês',
                        fonte: 'Disponível em: www.mangueira.com.br.\n' +
                            'Acesso em: 30 maio 2024 (fragmento).'
                    },
                ]
            },
            {
                titulo: 'Desafios para a valorização da herança africana no Brasil',
                imagem: './src/assets/images/img-tema-1.jpg',
                textosMotivadores: [
                    {
                        titulo: '',
                        imagem:'./src/assets/images/img-tema-1.jpg',
                        texto: ' Herança – o legado de crenças, conhecimentos, técnicas, costumes, tradições, transmitido por um grupo social de geração para geração; cultura.',
                        fonte: 'HOUAISS, A.; VILLAR, M. S. Dicionário Houaiss da língua portuguesa. Rio de Janeiro: Objetiva, 2009 (adaptado).'
                    },
                    {
                        titulo: '',
                        imagem: '',
                        texto: 'As culturas africanas e afro-brasileiras foram relegadas ao campo do folclore com o propósito de confiná-las ao gueto fossilizado da memória. Folclorizar, nesse caso, é reduzir uma cultura a um conjunto de representações estereotipadas, via de regra, alheias ao contexto que produziu essa cultura.',
                        fonte: 'OLIVEIRA, E. D. A epistemologia da ancestralidade. Entrelugares: revista de sociopoética e abordagens afins, 2009.'
                    },
                    {
                        titulo: ' História afro-brasileira nas escolas: professoras comentam avanços e dificuldades',
                        imagem: '',
                        texto: ' As aulas sobre escravidão eram motivo de vergonha para uma professora quando ela estudava em uma escola municipal na zona sul de São Paulo. “Era o meu pior momento na escola”, lembra a ex-aluna. Naquela época, a história da população negra no Brasil era reduzida ao horror do período escravocrata. Não se falava na escola sobre temas como a história e a cultura afro-brasileira, muito menos sobre as grandes personalidades negras do país, como Luiz Gama e Carolina Maria de Jesus.\n' +
                            'A pedagoga, que é negra, tem orgulho de oferecer uma experiência diferente da que viveu em sala de aula para seus alunos. Agora os livros infantis levados para a turmas têm protagonistas pretos. Temas como a beleza do cabelo crespo e o combate ao racismo fazem parte do dia a dia da escola.',
                        fonte: 'Disponível em: https://jornal.unesp.br.Acesso em: 3 jun. 2024 (adaptado).'
                    },
                    {
                        titulo: 'Histórias para ninar gente grande',
                        imagem: '',
                        texto: ' Brasil, meu nego\n' +
                            ' Deixa eu te contar\n' +
                            ' A história que a história não conta\n' +
                            ' O avesso do mesmo lugar\n' +
                            ' Na luta é que a gente se encontra\n' +
                            ' Brasil, meu dengo\n' +
                            ' A Mangueira chegou\n' +
                            ' Com versos que o livro apagou\n' +
                            ' Desde 1500 tem mais invasão do que descobrimento\n' +
                            ' Tem sangue retinto pisado\n' +
                            ' Atrás do herói emoldurado\n' +
                            ' Mulheres, tamoios, mulatos\n' +
                            ' Eu quero um país que não está no retrato\n' +
                            ' Brasil, o teu nome é Dandara\n' +
                            ' E a tua cara é de cariri\n' +
                            ' Não veio do céu\n' +
                            ' Nem das mãos de Isabel\n' +
                            ' A liberdade é um dragão no mar de Aracati\n' +
                            ' Salve os caboclos de julho\n' +
                            ' Quem foi de aço nos anos de chumbo\n' +
                            ' Brasil, chegou a vez\n' +
                            ' De ouvir as Marias, Mahins, Marielles, malês',
                        fonte: 'Disponível em: www.mangueira.com.br.\n' +
                            'Acesso em: 30 maio 2024 (fragmento).'
                    },
                ]
            },
        ]
    },
    mutations: {
        myMutation(state, payload) {
            state.myState = payload
        },
    },
    actions: {
        myAction({commit}, payload) {
            commit('myMutation', payload)
        },
    },
})

export default store