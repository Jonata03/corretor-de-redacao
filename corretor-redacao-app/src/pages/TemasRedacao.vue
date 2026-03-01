<template>
  <div>
    <BarraNavegarReescrever numero-pagina="1"
                            titulo-botao-principal="Tema Livre"
                            @retornar="retornar"
                            :com-botao-principal="false"></BarraNavegarReescrever>
    <v-container>
      <div class="d-flex justify-space-around flex-wrap align-center">
        <v-card v-for="(tema, index) in temas" :key="index" @click="escolherTema(tema)"
                width="31%" height="280px" class="my-5 elevation-3" rounded="xl">
          <v-img :src="tema.imagem" height="47%" cover></v-img>
          <v-card-title class="font-weight-medium text-center text-wrap px-4 bg-grey-lighten-5h-100">
            {{ tema.titulo }}
          </v-card-title>
        </v-card>
      </div>
    </v-container>
    <TextosMotivadores v-if="abrirModal"
                       :tema="temaSelecionado"
                       :id-tema="temaSelecionado.id"
                       :abrir-modal="abrirModal"
                       @selecionarTema="selecionarTema"
                       @fecharModal="fecharModal"/>
  </div>
</template>
<script>
import BarraNavegarReescrever from "@/components/barraNevegacao/BarraNavegarReescrever.vue";
import ModalTextosMotivadores from "@/components/modal/ModalTextosMotivadores.vue";
import {mapActions} from "vuex";
import actionTypes from "@/core/constants/actionTypes.js";
import axios from "axios";
import {isEmpty} from "vuetify/lib/util/index.js";

export default {
  name: "TemasRedacao",
  components: {BarraNavegarReescrever, TextosMotivadores: ModalTextosMotivadores},
  data() {
    return {
      redacao: {},
      temas: [],
      temaSelecionado: {},
      abrirModal: false
    };
  },
  async mounted() {
    await this.buscarTemasDisponiveis();
  },
  methods: {
    ...mapActions({
      buscarTemasRedacao: actionTypes.TEMA.BUSCAR_TEMAS
    }),
    async buscarTemasDisponiveis() {
      this.redacao.id = this.$route.params.id
      const temas = await axios.get('http://localhost:8080/corretor-redacao/api/redacao/temas');
      this.temas = temas.data.tema;
      this.inserirImagens(temas.data.tema)
    },
    inserirImagens(temas) {
      const imagensPorId = {
        1: './src/assets/images/temas/tema-livre.png',
        2: './src/assets/images/temas/img-tema-1.jpg',
      };
      const temasComImagem = temas.map(tema => {
        return {
          ...tema,
          imagem: imagensPorId[tema.id] || './src/assets/images/default.png',
          textosInformativos: tema.textosInformativos
              ? tema.textosInformativos.map(texto => ({
                ...texto,
                imagem: texto.imagem
                    ? `./src/assets/images/${texto.imagem}/`
                    : null
              }))
              : []
        };
      });

      this.temas = temasComImagem;
    },
    retornar() {
      this.$router.push('/');
    },
    escolherTema(tema) {
      this.temaSelecionado = tema;
      this.abrirModal = true;
    },
    fecharModal() {
      this.abrirModal = false;
    },
    async selecionarTema() {
      if (isEmpty(this.$route.params.id)) {
        this.redacao = await this.salvarRedacao()
      } else {
        this.redacao = await axios.put(`http://localhost/corretor-redacao/api/redacao/escrita/editar/${this.redacao.id}`, {
          temaId: this.temaSelecionado.id
        });
      }
      this.$router.replace(`/escrever/${this.redacao.id}`);
    },
    async salvarRedacao() {

      const salvar = await axios.post('http://localhost/corretor-redacao/api/redacao/escrita/salvar', {
        temaId: this.temaSelecionado.id
      });
      return salvar.data
    }
  }
}
</script>
<style scoped>
.container-laranja {
  background-color: #FFAB40;
  padding: 15px;
  align-content: center;
  line-height: 0.1;
}

.secao-textos-motivadores {
  padding: 2% 5%;
  white-space: pre-line;
}
</style>