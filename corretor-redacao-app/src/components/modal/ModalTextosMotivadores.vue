<template>
  <v-dialog activator="parent" max-width="80%">
    <template v-slot:default="{ isActive }">
      <v-card class="dialog-card d-block">
        <div class="container-laranja">
          <v-card-title class="text-h4 text-wrap text-center text-grey-lighten-5 font-weight-bold pa-0">
            {{ tema.titulo }}
          </v-card-title>
        </div>
        <div class="secao-textos-motivadores">
          <div v-for="(texto, idx) in tema.textosInformativos" :key="idx">
            <v-divider v-if="idx !== 0" class="my-4"></v-divider>
            <v-card-title class="text-h5 text-center font-weight-bold text-wrap">
              Texto {{ (idx + 1) }}: {{ texto.titulo }}
            </v-card-title>
            <v-card-text v-if="tema.textosInformativos[idx].texto !== ''"
                         class="d-flex justify-center text-justify text-body-2 py-0">
              {{ texto.textosInformativos }}
            </v-card-text>
            <v-img :v-if="tema.textosInformativos[idx].imagem !== ''"
                   :src="tema.textosInformativos[idx].imagem"
                   max-width="80%"
                   class="py-3 ma-auto"/>
            <p class="text-center text-caption legenda"> {{ texto.fonte }} </p>
          </div>
          <div v-if="idTema !== 0">
            <v-divider class="my-4"></v-divider>
            <v-card-title class="text-h5 text-center font-weight-bold text-wrap">
              PROPOSTA DE REDAÇÃO
            </v-card-title>
            <v-card-text class="d-flex justify-center text-justify text-body-2 py-0">
              A partir da leitura dos textos motivadores e com base nos conhecimentos construídos ao longo de sua formação, redija um texto dissertativo-argumentativo em modalidade escrita formal da língua portuguesa sobre o tema “{{ tema.titulo }}”, apresentando proposta de intervenção que respeite os direitos humanos. Selecione, organize e relacione, de forma coerente e coesa, argumentos e fatos para defesa de seu ponto de vista.
            </v-card-text>
          </div>
        </div>
        <div class="container-laranja">
          <v-card-actions class="justify-end">
            <v-btn
                class="mr-4 bg-white"
                text="Fechar"
                @click="fecharModal()"
                color="orange"
                variant="tonal"
            ></v-btn>
            <v-btn
                v-if="idTema != null"
                class="mr-4 bg-white"
                text="Escolher Tema"
                @click="selecionarTema"
                color="orange"
                variant="tonal"
            ></v-btn>
          </v-card-actions>
        </div>
      </v-card>
    </template>
  </v-dialog>
</template>

<script>
export default {
  name: "TextosMotivadores",
  data() {
    return {

    }
  },
  props: {
    tema: {
      type: Object,
      required: true
    },
    idTema: String,
    abrirModal: {
      type: Boolean,
      required: true
    }
  },
  mounted() {
  },
  methods:{
    fecharModal(){
      this.$emit('fecharModal');
    },
    selecionarTema(){
      this.$emit('selecionarTema', this.tema);
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