<template>
  <v-container width="100%"
               height="100%"
               class="pa-0">
    <v-textarea
      :v-model="texto"
      outlined
      rows="10"
      class="ma-2"></v-textarea>
  </v-container>
</template>
<script>
    export default {
      props:{
        texto: {
          type: String,
          default: ''
        }
      }
    }
</script>
<style scoped>

</style>