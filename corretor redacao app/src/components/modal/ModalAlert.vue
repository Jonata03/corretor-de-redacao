

<template>
<div>
  <v-alert :title="title"
           :icon="icon"
           :color="color"/>
</div>
</template>
<script>
export default {
  name: 'ModalAlert',
  props: {
    title: {
      type: String,
      default: ''
    },
    color: {
      type: String,
      default: 'success'
    },
    icon: {
      type: String,
      default: 'mdi-check-circle'
    }
  },
  methods:{
    close() {
      this.$emit('close')
    }
  }
}
</script>
<style scoped>

</style>