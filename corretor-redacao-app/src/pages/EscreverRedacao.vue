<template>
  <div>
    <BarraNavegarReescrever @acaoBotaoPrincipal="corrigirRedacao"
                            @retornar="retornar"
                            numero-pagina="2"
                            titulo-botao-principal="Corrigir"/>
    <v-container class="pa-6">
      <div class="container-tema">
                <h1 class="text-h4">Tema: {{ tema.titulo }}</h1>
        <div class="container-icon">
          <v-btn icon="mdi mdi-tooltip-text" v-tooltip:top="'Ver textos motivadores'" @click="visualizarTextos"/>
        </div>
      </div>
      <v-text-field
          label="Título (Opcional)"
          variant="outlined"
          hide-details
          v-model="redacao.titulo"
          @blur="salvarRedacao"
          class="mb-4 bg-white titulo-text-field"
      />
      <div class="lined-paper">
        <textarea
            v-model="redacao.texto"
            class="lined-textarea"
            @blur="salvarRedacao"
            placeholder="Escreva sua redação aqui..."
        ></textarea>
      </div>
    </v-container>
    <TextosMotivadores
        v-if="abrirModal"
        :tema="tema"
        :abrir-modal="abrirModal"
        @fecharModal="fecharModal"
    />
  </div>
</template>
<script>
import BarraNavegarReescrever from '@/components/barraNevegacao/BarraNavegarReescrever.vue'
import {corrigirRedacao} from "@/services/integracaoChatGpt.js";
import ModalTextosMotivadores from "@/components/modal/ModalTextosMotivadores.vue";
import {mapState} from "vuex";
import axios from "axios";

export default {
  components: {
    BarraNavegarReescrever,
    TextosMotivadores: ModalTextosMotivadores
  },
  data() {
    return {
      redacao: {},
      tema: {},
      abrirModal: false,
      teste : {
        "competencia1": {
          "nota": 200,
          "justificativa": "O texto apresenta excelente domínio da norma culta da língua escrita, sem erros de ortografia, acentuação, pontuação ou concordância. O vocabulário é adequado e variado."
        },
        "competencia2": {
          "nota": 200,
          "justificativa": "O autor compreendeu perfeitamente a proposta e desenvolveu o tema de forma clara e consistente, abordando a manipulação do comportamento de usuários pela seleção prévia de dados na internet."
        },
        "competencia3": {
          "nota": 200,
          "justificativa": "O texto apresenta argumentos bem selecionados e organizados, com defesa clara de um ponto de vista. As ideias são apresentadas de forma lógica e coerente, com uso de exemplos e referências teóricas."
        },
        "competencia4": {
          "nota": 200,
          "justificativa": "O texto é coeso, com excelente articulação entre as partes, uso adequado de conectivos e progressão clara das ideias. A fluidez do texto é muito boa."
        },
        "competencia5": {
          "nota": 200,
          "justificativa": "A proposta de intervenção é clara, coerente e factível, envolvendo agente, ação, meio e finalidade. A proposta respeita os direitos humanos e está diretamente relacionada ao problema discutido no texto."
        },
      }
    }
  },
  async mounted() {
     await this.buscarRedacaoPorId(this.$route.params.idRedacao)
  },
  methods: {
    async buscarRedacaoPorId(id) {
      const redacao = await axios.get(`http://localhost/corretor-redacao/api/redacao/buscar/${id}`);
      this.redacao = redacao.data.redacao
      this.tema = redacao.data.tema
    },
    async corrigirRedacao() {
      // const resposta = await corrigirRedacao(this.redacao)
      // const avaliacao = await JSON.parse(resposta)
      await this.salvarRedacao()
      await this.salvarCorrecao()
      this.$router.push('/correcao-redacao/' + this.redacao.id)
    },
    async salvarCorrecao(){
      return await axios.put(`http://localhost/corretor-redacao/api/redacao/avaliar/${this.redacao.id}`, this.teste)
    },
    async salvarRedacao() {
      return await axios.put(`http://localhost/corretor-redacao/api/redacao/escrita/editar/${this.redacao.id}`, {
        titulo: this.redacao.titulo,
        texto: this.redacao.texto,
        temaId: this.tema.id
      });
    },
    retornar() {
      this.$router.push(`/editar-tema/${this.redacao.id}`);
    },
    visualizarTextos(){
      this.abrirModal = true
    },
    fecharModal(){
      console.log(this.tema)
      this.abrirModal = false;
    }
  }
}
</script>
<style scoped>
.container-tema {
  display: flex;
  padding: 20px 0 20px 20px;
  margin: 20px 0;
  background-color: white;
  border: 1px solid #aaa;
  border-radius: 5px;
  text-align: center;
}

.container-tema h1 {
  width: 90%;
}

.container-icon {
  align-content: center;
  width: 10%;
}

.titulo-text-field ::v-deep(input) {
  font-size: 20px;
}

.lined-paper {
  position: relative;
  width: 100%;
  height: 900px;
  border: 1px solid #aaa;
  border-radius: 5px;
  overflow: hidden;
  margin-top: 20px;
}

.lined-paper::before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  height: 100%;
  background-image: repeating-linear-gradient(
      to bottom,
      white,
      white 28px,
      #aaa 30px
  );
  pointer-events: none;
  z-index: 0;
}

.lined-textarea {
  position: relative;
  width: 100%;
  height: 100%;
  border: none;
  resize: none;
  background: transparent;
  font-size: 16px;
  line-height: 30px;
  padding: 0 8px;
  outline: none;
  z-index: 1;
  overflow: hidden;
}
</style>