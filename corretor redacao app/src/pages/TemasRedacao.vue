<template>
  <div>
    <BarraNavegarReescrever numero-pagina="1"
                            titulo-botao-principal="Tema Livre"
                            @acaoBotaoPrincipal="escreverRedacao"
                            @retornar="retornar"></BarraNavegarReescrever>
    <v-container>
      <div class="d-flex justify-space-around flex-wrap align-center">
        <v-card v-for="(tema, index) in temas" :key="index"
                width="28%" height="250px" class="my-5 elevation-3">
          <v-img :src="tema.imagem" height="43%" cover></v-img>
          <v-card-title class="font-weight-medium text-start text-wrap px-4">
            {{ tema.titulo }}
          </v-card-title>
          <v-dialog activator="parent" max-width="80%">
            <template v-slot:default="{ isActive }">
              <v-card class="dialog-card d-block">
                <div class="container-laranja">
                  <v-card-title class="text-h4 text-wrap text-center text-grey-lighten-5 font-weight-bold pa-0">
                    {{ tema.titulo }}
                  </v-card-title>
                </div>
                <div class="secao-textos-motivadores">
                  <div v-for="(texto, idx) in temas[index].textosMotivadores" :key="idx">
                    <v-divider v-if="idx!==0" class="my-4"></v-divider>
                    <v-card-title class="text-h5 text-center font-weight-bold">
                      Texto {{ (idx + 1) }}: {{ texto.titulo }}
                    </v-card-title>
                    <v-card-text class="d-flex justify-center text-justify text-body-2 primeira-linha py-2">
                      {{ texto.texto }}
                    </v-card-text>
                    <v-img :v-if="tema.textosMotivadores[idx].imagem != null"
                           :src="tema.textosMotivadores[idx].imagem"
                           class="py-3"/>
                    <p class="text-center text-caption legenda"> {{ texto.fonte }} </p>
                  </div>
                </div>
                <div class="container-laranja">
                  <v-card-actions class="justify-end">
                    <v-btn
                        class="mr-4 bg-white"
                        text="Cancelar"
                        @click="isActive.value = false"
                        color="orange"
                        variant="tonal"
                    ></v-btn>
                    <v-btn
                        class="mr-4 bg-white"
                        text="Escolher Tema"
                        :to="'/escrever/'+index"
                        color="orange"
                        variant="tonal"
                    ></v-btn>
                  </v-card-actions>
                </div>
              </v-card>
            </template>
          </v-dialog>
        </v-card>
      </div>
    </v-container>
  </div>
</template>
<script>
import BarraNavegarReescrever from "@/components/barraNevegacao/BarraNavegarReescrever.vue";
import {mapState} from "vuex";

export default {
  name: "TemasRedacao",
  components: {BarraNavegarReescrever},
  data() {
    return {
      cards: [
        {
          title: 'Desafios para a valorização da herança africana no Brasil',
          image: './src/assets/images/img-tema-1.jpg',
          textosMotivadores: [
            {
              titulo: '',
              texto: ' Herança – o legado de crenças, conhecimentos, técnicas, costumes, tradições, transmitido por um grupo social de geração para geração; cultura.',
              fonte: 'HOUAISS, A.; VILLAR, M. S. Dicionário Houaiss da língua portuguesa. Rio de Janeiro: Objetiva, 2009 (adaptado).'
            },
            {
              titulo: '',
              texto: 'As culturas africanas e afro-brasileiras foram relegadas ao campo do folclore com o propósito de confiná-las ao gueto fossilizado da memória. Folclorizar, nesse caso, é reduzir uma cultura a um conjunto de representações estereotipadas, via de regra, alheias ao contexto que produziu essa cultura.',
              fonte: 'OLIVEIRA, E. D. A epistemologia da ancestralidade. Entrelugares: revista de sociopoética e abordagens afins, 2009.'
            },
            {
              titulo: ' História afro-brasileira nas escolas: professoras comentam avanços e dificuldades',
              texto: ' As aulas sobre escravidão eram motivo de vergonha para uma professora quando ela estudava em uma escola municipal na zona sul de São Paulo. “Era o meu pior momento na escola”, lembra a ex-aluna. Naquela época, a história da população negra no Brasil era reduzida ao horror do período escravocrata. Não se falava na escola sobre temas como a história e a cultura afro-brasileira, muito menos sobre as grandes personalidades negras do país, como Luiz Gama e Carolina Maria de Jesus.\n' +
                  'A pedagoga, que é negra, tem orgulho de oferecer uma experiência diferente da que viveu em sala de aula para seus alunos. Agora os livros infantis levados para a turmas têm protagonistas pretos. Temas como a beleza do cabelo crespo e o combate ao racismo fazem parte do dia a dia da escola.',
              fonte: 'Disponível em: https://jornal.unesp.br.Acesso em: 3 jun. 2024 (adaptado).'
            },
            {
              titulo: 'Histórias para ninar gente grande',
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
          title: 'Desafios para a valorização da herança africana no Brasil',
          image: './src/assets/images/img-tema-1.jpg',
          textosMotivadores: [
            {
              titulo: '',
              texto: 'Herança – o legado de crenças, conhecimentos, técnicas, costumes, tradições, transmitido por um grupo social de geração para geração; cultura.',
              fonte: 'HOUAISS, A.; VILLAR, M. S. Dicionário Houaiss da língua portuguesa. Rio de Janeiro: Objetiva, 2009 (adaptado).'
            },
            {
              titulo: '',
              texto: 'As culturas africanas e afro-brasileiras foram relegadas ao campo do folclore com o propósito de confiná-las ao gueto fossilizado da memória. Folclorizar, nesse caso, é reduzir uma cultura a um conjunto de representações estereotipadas, via de regra, alheias ao contexto que produziu essa cultura.',
              fonte: 'OLIVEIRA, E. D. A epistemologia da ancestralidade. Entrelugares: revista de sociopoética e abordagens afins, 2009.'
            },
            {
              titulo: 'História afro-brasileira nas escolas: professoras\n' +
                  'comentam avanços e dificuldades',
              texto: 'As aulas sobre escravidão eram motivo de vergonha para uma professora quando ela estudava em uma escola municipal na zona sul de São Paulo. “Era o meu pior momento na escola”, lembra a ex-aluna. Naquela época, a história da população negra no Brasil era reduzida ao horror do período escravocrata. Não se falava na escola sobre temas como a história e a cultura afro-brasileira, muito menos sobre as grandes personalidades negras do país, como Luiz Gama e Carolina Maria de Jesus.\n' +
                  'A pedagoga, que é negra, tem orgulho de oferecer uma experiência diferente da que viveu em sala de aula para seus alunos. Agora os livros infantis levados para a turmas têm protagonistas pretos. Temas como a beleza do cabelo crespo e o combate ao racismo fazem parte do dia a dia da escola.',
              fonte: 'Disponível em: https://jornal.unesp.br.Acesso em: 3 jun. 2024 (adaptado).'
            },
            {
              titulo: 'Histórias para ninar gente grande\n' +
                  'G.R.E.S. Estação Primeira de Mangueira\n' +
                  '(samba-enredo de 2019)',
              texto: 'Brasil, meu nego\n' +
                  'Deixa eu te contar\n' +
                  'A história que a história não conta\n' +
                  'O avesso do mesmo lugar\n' +
                  'Na luta é que a gente se encontra\n' +
                  'Brasil, meu dengo\n' +
                  'A Mangueira chegou\n' +
                  'Com versos que o livro apagou\n' +
                  'Desde 1500 tem mais invasão do que descobrimento\n' +
                  'Tem sangue retinto pisado\n' +
                  'Atrás do herói emoldurado\n' +
                  'Mulheres, tamoios, mulatos\n' +
                  'Eu quero um país que não está no retrato\n' +
                  'Brasil, o teu nome é Dandara\n' +
                  'E a tua cara é de cariri\n' +
                  'Não veio do céu\n' +
                  'Nem das mãos de Isabel\n' +
                  'A liberdade é um dragão no mar de Aracati\n' +
                  'Salve os caboclos de julho\n' +
                  'Quem foi de aço nos anos de chumbo\n' +
                  'Brasil, chegou a vez\n' +
                  'De ouvir as Marias, Mahins, Marielles, malês',
              fonte: 'Disponível em: www.mangueira.com.br.\n' +
                  'Acesso em: 30 maio 2024 (fragmento).'
            },
          ]
        },
        {
          title: 'Desafios para a valorização da herança africana no Brasil',
          image: './src/assets/images/img-tema-1.jpg',
          textosMotivadores: [
            {
              titulo: '',
              texto: 'Herança – o legado de crenças, conhecimentos, técnicas, costumes, tradições, transmitido por um grupo social de geração para geração; cultura.',
              fonte: 'HOUAISS, A.; VILLAR, M. S. Dicionário Houaiss da língua portuguesa. Rio de Janeiro: Objetiva, 2009 (adaptado).'
            },
            {
              titulo: '',
              texto: 'As culturas africanas e afro-brasileiras foram relegadas ao campo do folclore com o propósito de confiná-las ao gueto fossilizado da memória. Folclorizar, nesse caso, é reduzir uma cultura a um conjunto de representações estereotipadas, via de regra, alheias ao contexto que produziu essa cultura.',
              fonte: 'OLIVEIRA, E. D. A epistemologia da ancestralidade. Entrelugares: revista de sociopoética e abordagens afins, 2009.'
            },
            {
              titulo: 'História afro-brasileira nas escolas: professoras\n' +
                  'comentam avanços e dificuldades',
              texto: 'As aulas sobre escravidão eram motivo de vergonha para uma professora quando ela estudava em uma escola municipal na zona sul de São Paulo. “Era o meu pior momento na escola”, lembra a ex-aluna. Naquela época, a história da população negra no Brasil era reduzida ao horror do período escravocrata. Não se falava na escola sobre temas como a história e a cultura afro-brasileira, muito menos sobre as grandes personalidades negras do país, como Luiz Gama e Carolina Maria de Jesus.\n' +
                  'A pedagoga, que é negra, tem orgulho de oferecer uma experiência diferente da que viveu em sala de aula para seus alunos. Agora os livros infantis levados para a turmas têm protagonistas pretos. Temas como a beleza do cabelo crespo e o combate ao racismo fazem parte do dia a dia da escola.',
              fonte: 'Disponível em: https://jornal.unesp.br.Acesso em: 3 jun. 2024 (adaptado).'
            },
            {
              titulo: 'Histórias para ninar gente grande\n' +
                  'G.R.E.S. Estação Primeira de Mangueira\n' +
                  '(samba-enredo de 2019)',
              texto: 'Brasil, meu nego\n' +
                  'Deixa eu te contar\n' +
                  'A história que a história não conta\n' +
                  'O avesso do mesmo lugar\n' +
                  'Na luta é que a gente se encontra\n' +
                  'Brasil, meu dengo\n' +
                  'A Mangueira chegou\n' +
                  'Com versos que o livro apagou\n' +
                  'Desde 1500 tem mais invasão do que descobrimento\n' +
                  'Tem sangue retinto pisado\n' +
                  'Atrás do herói emoldurado\n' +
                  'Mulheres, tamoios, mulatos\n' +
                  'Eu quero um país que não está no retrato\n' +
                  'Brasil, o teu nome é Dandara\n' +
                  'E a tua cara é de cariri\n' +
                  'Não veio do céu\n' +
                  'Nem das mãos de Isabel\n' +
                  'A liberdade é um dragão no mar de Aracati\n' +
                  'Salve os caboclos de julho\n' +
                  'Quem foi de aço nos anos de chumbo\n' +
                  'Brasil, chegou a vez\n' +
                  'De ouvir as Marias, Mahins, Marielles, malês',
              fonte: 'Disponível em: www.mangueira.com.br.\n' +
                  'Acesso em: 30 maio 2024 (fragmento).'
            },
          ]
        },
        {
          title: 'Desafios para a valorização da herança africana no Brasil',
          image: './src/assets/images/img-tema-1.jpg',
          textosMotivadores: [
            {
              titulo: '',
              texto: 'Herança – o legado de crenças, conhecimentos, técnicas, costumes, tradições, transmitido por um grupo social de geração para geração; cultura.',
              fonte: 'HOUAISS, A.; VILLAR, M. S. Dicionário Houaiss da língua portuguesa. Rio de Janeiro: Objetiva, 2009 (adaptado).'
            },
            {
              titulo: '',
              texto: 'As culturas africanas e afro-brasileiras foram relegadas ao campo do folclore com o propósito de confiná-las ao gueto fossilizado da memória. Folclorizar, nesse caso, é reduzir uma cultura a um conjunto de representações estereotipadas, via de regra, alheias ao contexto que produziu essa cultura.',
              fonte: 'OLIVEIRA, E. D. A epistemologia da ancestralidade. Entrelugares: revista de sociopoética e abordagens afins, 2009.'
            },
            {
              titulo: 'História afro-brasileira nas escolas: professoras\n' +
                  'comentam avanços e dificuldades',
              texto: 'As aulas sobre escravidão eram motivo de vergonha para uma professora quando ela estudava em uma escola municipal na zona sul de São Paulo. “Era o meu pior momento na escola”, lembra a ex-aluna. Naquela época, a história da população negra no Brasil era reduzida ao horror do período escravocrata. Não se falava na escola sobre temas como a história e a cultura afro-brasileira, muito menos sobre as grandes personalidades negras do país, como Luiz Gama e Carolina Maria de Jesus.\n' +
                  'A pedagoga, que é negra, tem orgulho de oferecer uma experiência diferente da que viveu em sala de aula para seus alunos. Agora os livros infantis levados para a turmas têm protagonistas pretos. Temas como a beleza do cabelo crespo e o combate ao racismo fazem parte do dia a dia da escola.',
              fonte: 'Disponível em: https://jornal.unesp.br.Acesso em: 3 jun. 2024 (adaptado).'
            },
            {
              titulo: 'Histórias para ninar gente grande\n' +
                  'G.R.E.S. Estação Primeira de Mangueira\n' +
                  '(samba-enredo de 2019)',
              texto: 'Brasil, meu nego\n' +
                  'Deixa eu te contar\n' +
                  'A história que a história não conta\n' +
                  'O avesso do mesmo lugar\n' +
                  'Na luta é que a gente se encontra\n' +
                  'Brasil, meu dengo\n' +
                  'A Mangueira chegou\n' +
                  'Com versos que o livro apagou\n' +
                  'Desde 1500 tem mais invasão do que descobrimento\n' +
                  'Tem sangue retinto pisado\n' +
                  'Atrás do herói emoldurado\n' +
                  'Mulheres, tamoios, mulatos\n' +
                  'Eu quero um país que não está no retrato\n' +
                  'Brasil, o teu nome é Dandara\n' +
                  'E a tua cara é de cariri\n' +
                  'Não veio do céu\n' +
                  'Nem das mãos de Isabel\n' +
                  'A liberdade é um dragão no mar de Aracati\n' +
                  'Salve os caboclos de julho\n' +
                  'Quem foi de aço nos anos de chumbo\n' +
                  'Brasil, chegou a vez\n' +
                  'De ouvir as Marias, Mahins, Marielles, malês',
              fonte: 'Disponível em: www.mangueira.com.br.\n' +
                  'Acesso em: 30 maio 2024 (fragmento).'
            },
          ]
        },
      ]
    };
  },
  computed: {
    ...mapState({
      temas: state => state.temasRedacao
    })
  },
  methods: {
    escreverRedacao() {
      this.$router.push('/escrever/0')
    },
    retornar() {
      this.$router.push('/');
    }
  }
}
</script>
<style scoped>
.container-laranja {
  background-color: #FFAB40;
  height: 100px;
  align-content: center;
}
.secao-textos-motivadores {
  padding: 2% 5%;
  white-space: pre-line;
}
</style>