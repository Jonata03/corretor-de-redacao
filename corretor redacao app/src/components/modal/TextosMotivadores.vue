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
          <div v-for="(texto, idx) in tema.textosMotivadores" :key="idx">
            <v-divider v-if="idx!==0" class="my-4"></v-divider>
            <v-card-title class="text-h5 text-center font-weight-bold">
              Texto {{ (idx + 1) }}: {{ texto.titulo }}
            </v-card-title>
            <v-card-text v-if="tema.textosMotivadores[idx].texto !== ''"
                         class="d-flex justify-center text-justify text-body-2 py-0">
              {{ texto.texto }}
            </v-card-text>
            <v-img :v-if="tema.textosMotivadores[idx].imagem !== ''"
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
</template>

<script>
export default {
  name: "TextosMotivadores",
  props: {
    tema: {
      type: Object,
      required: true
    }
  },
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