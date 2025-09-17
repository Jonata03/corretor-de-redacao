<template>
  <div>
    <BarraNavegarReescrever @acaoBotaoPrincipal="corrigirRedacao"
                            @retornar = "retornar"
                            numero-pagina="2"
                            titulo-botao-principal="Corrigir"/>
    <v-container class="pa-6">
      <div class="container-tema">
        <TextosMotivadores :tema="getTema()"/>
        <h1 class="text-h4">Tema: {{ getTema().titulo }}</h1>
        <div class="container-icon">
          <v-btn icon="mdi mdi-tooltip-text" v-tooltip:top="'Ver textos motivadores'"/>
        </div>
      </div>
      <v-text-field
          label="Título (Opcional)"
          variant="outlined"
          hide-details
          class="mb-4 bg-white titulo-text-field"
      />
      <div class="lined-paper">
        <textarea
            v-model = "redacao"
            class="lined-textarea"
            placeholder="Escreva sua redação aqui..."
        ></textarea>
      </div>
    </v-container>
  </div>
</template>
<script>
import BarraNavegarReescrever from '@/components/barraNevegacao/BarraNavegarReescrever.vue'
import {corrigirRedacao} from "@/services/integracaoChatGpt.js";
import ModalTextosMotivadores from "@/components/modal/ModalTextosMotivadores.vue";
import {mapState} from "vuex";
export default {
  components: {
    BarraNavegarReescrever,
    TextosMotivadores: ModalTextosMotivadores
  },
  data() {
    return {
      redacao: ''
    }
  },
  computed: {
    ...mapState({
      temas: state => state.temasRedacao
    })
  },
  methods: {
    getTema(){
      return this.temas[this.$route.params.idTema]
    },
    async corrigirRedacao(){
      const resposta = await corrigirRedacao(this.redacao)
      const jsonResposta = await JSON.parse(resposta)
      console.log(jsonResposta)
      this.$router.push('/correcao-redacao/' + this.$route.params.idTema)
    },
    retornar(){
      this.$router.go(-1)
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

.titulo-text-field ::v-deep(input){
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