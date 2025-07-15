<template>
  <v-btn
      class="mb-2 bg-green tamanhoBotao"
      @click="$emit('compartilhar')"
  >
    <v-icon left>mdi-share-variant</v-icon>
    Compartilhar
  </v-btn>
</template>
<script>

</script>
<style scoped>
  .tamanhoBotao{
    font-size: 8px;
  }
</style>