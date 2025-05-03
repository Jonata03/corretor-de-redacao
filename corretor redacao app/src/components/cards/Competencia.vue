<template>
  <v-card
      class="ma-2 d-flex flex-column align-center justify-center"
      width="20%"
  >
    <v-card-title :style="{color: corTitulo}"
                  class="text-body-1 font-weight-bold card pb-1">
    {{ titulo }}</v-card-title>
    <v-card-text>
      <span class="text-h6">{{ totalObtido }}</span> / {{ totalMaximo }}
    </v-card-text>
  </v-card>
</template>
<script>
export default {
  props: {
    titulo: {
      type: String,
      default: ''
    },
    corTitulo: {
      type: String,
      default: ''
    },
    totalObtido: {
      type: Number,
      default: 0
    },
    totalMaximo: {
      type: Number,
      default: 0
    }
  }
}
</script>

<style scoped>
.card{
  border-bottom: solid gray 1px;
}
</style>