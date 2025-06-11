<template>
  <v-layout class="mb-14">
    <v-app-bar flat elevation="2">
      <v-container class="d-flex justify-space-between align-center pa-0 bg-white ">
        <button @click="retornar">
          <v-icon color="grey">mdi-chevron-left</v-icon>
        </button>
        <!-- Etapas no topo -->
        <div class="d-flex align-center justify-space-between">
          <div class="step-wrapper">
            <v-chip :color="corVChipPaginacao('1')" class="">1</v-chip>
            <span :class="corSpanPaginacao('1')">Escolha um tema</span>
            <v-chip :color="corVChipPaginacao('2')" class="ml-4">2</v-chip>
            <span :class="corSpanPaginacao('2')">Escreva sua redação</span>
            <v-chip :color="corVChipPaginacao('3')" class="ml-4">3</v-chip>
            <span :class="corSpanPaginacao('3')">Receba sua correção</span>
          </div>
        </div>
        <div>
          <button class="pa-1 mr-2 bg-orange rounded-50% textoBotao" @click="acaoBotaoPrincipal">
            <v-icon color="black">mdi-pen</v-icon>
            <span class="text-uppercase">{{ tituloBotaoPrincipal }}</span>
          </button>
          <v-btn @click="voltarParaTelaInicial" to="/">
            <v-icon>mdi-home</v-icon>
          </v-btn>
        </div>
      </v-container>
    </v-app-bar>
  </v-layout>
</template>
<script>
export default {
  name: 'BarraNavegarReescrever',
  props: {
    tituloBotaoPrincipal: {
      type: String,
      required: true
    },
    numeroPagina: {
      type: String,
      required: true
    }
  },
  methods: {
    retornar() {
      this.$emit('retornar');
    },
    voltarParaTelaInicial(){
      this.$emit('retonarParaPaginaInicial')
    },
    acaoBotaoPrincipal(){
      this.$emit('acaoBotaoPrincipal')
    },
    corVChipPaginacao(numero){
      if(numero === this.numeroPagina){
        return "deep-orange";
      }
      return "grey-lighten-1";
    },
    corSpanPaginacao(numero){
      if(numero === this.numeroPagina){
        return "text-orange-darken-4";
      }
      return "text-grey";
    }
  }
};
</script>
<style scoped>
.step-wrapper {
  display: flex;
  align-items: center;
  flex-wrap: wrap;
  gap: 10px;
}

.textoBotao {
  font-size: 0.7em;
  border-radius: 50px;
}
</style>