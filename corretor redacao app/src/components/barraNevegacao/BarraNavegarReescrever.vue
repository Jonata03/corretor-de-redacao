<template>
  <v-layout class="mb-14">
    <v-app-bar flat elevation="2">
      <v-container class="d-flex justify-space-between align-center pa-0 bg-white ">
        <button @click="retornar">
          <v-icon color="grey">mdi-chevron-left</v-icon>
        </button>
        <button class="pa-1 mr-2 bg-orange rounded-50% textoBotao">
          <v-icon color="black">mdi-pen</v-icon>
          <span class="text-uppercase">  reescrever</span>
        </button>
      </v-container>
    </v-app-bar>
  </v-layout>
</template>
<script>
export default {
  name: 'BarraNavegarReescrever',
  methods: {
    retornar() {
      this.$emit('retornar');
    }
  }
};
</script>
<style scoped>
.textoBotao {
  font-size: 0.7em;
  border-radius: 50px;
}
</style>