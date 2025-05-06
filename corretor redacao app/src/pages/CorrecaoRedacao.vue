<template>
  <div>
    <barra-navegar-reescrever/>
  <v-container>
    <v-card class="ma-2 d-flex justify-center  align-center flex-column">
      <v-card-title>
        <h6>Nota Redação</h6>
      </v-card-title>
      <v-card-text class="pa-0">
        <h3><span class="pontuacao">1000</span>/1000</h3>
      </v-card-text>
      <v-card-actions>
        <botao-compartilhar @compartilhar="compartilhar"/>
      </v-card-actions>
    </v-card>
    <div class="d-flex flex-row">
    <competencia v-for="competencia in competencias"
                 :titulo="competencia.titulo"
                 :corTitulo="competencia.corTitulo"
                 :totalObtido="competencia.totalObtido"
                 :totalMaximo="competencia.totalMaximo"
                 class="d-flex flex-column"
    />
    </div>
    <v-card class="ma-2 d-flex justify-center  align-center flex-column">
       <v-container class="card pa-1">
         <button class="pa-1 mr-2 ">
           <v-icon color="yellow">mdi-star</v-icon>
           <span class="text-uppercase">  comentar</span>
         </button>
         <button>
           <v-icon color="blue">mdi-marker</v-icon>
           <span class="text-uppercase"> demarcar</span>
         </button>
       </v-container>
      <v-list width="100%">
        <v-list-item>
            <v-list-item-title class="text-wrap subtitle">O silêncio do cuidado: a invisibilidade do trabalho feminino no Brasil</v-list-item-title>
            <p class="text-wrap">

              No romance Quarto de Despejo, Carolina Maria de Jesus revela a dura realidade das mulheres negras e pobres que,<br>
              mesmo sustentando suas famílias com trabalho e afeto, permanecem à margem da sociedade. Essa obra ainda ecoa nos dias atuais, quando o trabalho de cuidado — como limpar, cozinhar e cuidar de filhos ou idosos — segue sendo realizado majoritariamente por mulheres, muitas vezes sem remuneração, reconhecimento ou garantias. A invisibilidade dessa forma de trabalho não é apenas uma herança histórica, mas também um reflexo das desigualdades estruturais de gênero que persistem no Brasil.

              Em primeiro lugar, é preciso destacar que o trabalho de cuidado é fundamental para o funcionamento da sociedade, ainda que pouco valorizado. Segundo o IBGE, mulheres dedicam quase o dobro do tempo dos homens a afazeres domésticos e cuidados de pessoas. Essa sobrecarga contribui para a desigualdade no mercado de trabalho, já que limita a inserção e ascensão das mulheres em empregos formais e bem remunerados. Assim, perpetua-se um ciclo de desigualdade econômica e social que atinge, sobretudo, as mulheres negras e periféricas.

              Além disso, a desvalorização desse tipo de trabalho está ligada à construção cultural do papel feminino. Desde a infância, meninas são ensinadas a cuidar, servir e se responsabilizar pela família, como se essas tarefas fossem uma obrigação natural, e não uma escolha. Esse processo, reforçado por discursos midiáticos e educacionais, invisibiliza o esforço e a competência exigidos nesse cuidado, desconsiderando-o como um trabalho legítimo.

              Para enfrentar esse cenário, é imprescindível a formulação de políticas públicas que reconheçam e valorizem o trabalho de cuidado. O Estado deve ampliar a oferta de creches públicas em tempo integral, o que permitiria às mulheres maior autonomia para trabalhar ou estudar. Além disso, é essencial incluir na Base Nacional Comum Curricular (BNCC) conteúdos que discutam equidade de gênero desde os anos iniciais da educação básica, promovendo uma mudança cultural duradoura. Campanhas de conscientização, articuladas pelos Ministérios da Mulher e da Educação, também podem contribuir para desnaturalizar a ideia de que cuidar é uma obrigação feminina.

              Portanto, romper com a invisibilidade do trabalho de cuidado é uma tarefa urgente e coletiva. Tal como Carolina Maria de Jesus escancarou em sua obra o peso invisível que carregava, cabe hoje à sociedade brasileira reconhecer, valorizar e compartilhar o cuidado como responsabilidade de todos.</p>
        </v-list-item>
      </v-list>
    </v-card>
  </v-container>
  </div>
</template>
<script>
import BarraNavegarReescrever from '@/components/barraNevegacao/BarraNavegarReescrever.vue'
import BotaoCompartilhar from '@/components/BotaoCompartilhar.vue'
import Competencia from "@/components/cards/Competencia.vue";
import AreaTexto from "@/components/AreaTexto.vue";
export default {
  name: 'CorrecaoRedacao',
  components: {Competencia, BarraNavegarReescrever, BotaoCompartilhar, AreaTexto},
  data() {
    return {
      competencias:[{
        titulo: 'Competência 1',
        corTitulo: 'green',
        totalObtido: 200,
        totalMaximo: 200},
        {
          titulo: 'Competência 2',
          corTitulo: 'orange',
          totalObtido: 200,
          totalMaximo: 200
        },
        {
          titulo: 'Competência 3',
          corTitulo: 'red',
          totalObtido: 200,
          totalMaximo: 200
        },
        {
          titulo: 'Competência 4',
          corTitulo: 'blue',
          totalObtido: 200,
          totalMaximo: 200
        },
        {
          titulo: 'Competência 5',
          corTitulo: 'purple',
          totalObtido: 200,
          totalMaximo: 200
        }
      ]
    };
  },
  mounted() {
    this.$refs.modalAlert.show();
  },
  methods: {
    compartilhar() {
      console.log('Compartilhar a redação corrigida');
    },
  },
};
</script>
<style scoped>
  .pontuacao{
    font-size: 2em;
    font-weight: bold;
    color: #4CAF50;
  }
  .card{
    border-bottom: solid gray 1px;
  }
</style>