<template>
  <div>
    <BarraNavegarReescrever @acaoBotaoPrincipal="corrigirRedacao"
                            @retornar = "retornar"
                            numero-pagina="2"
                            titulo-botao-principal="Corrigir"/>
    <v-container class="pa-6">
      <v-text-field
          label="Título (Opcional)"
          variant="outlined"
          hide-details
          class="mb-4 bg-white"
      ></v-text-field>

      <div class="lined-paper">
        <textarea
            class="lined-textarea"
            placeholder="Escreva sua redação aqui..."
        ></textarea>
      </div>
    </v-container>
  </div>
</template>
<script>
import BarraNavegarReescrever from '@/components/barraNevegacao/BarraNavegarReescrever.vue'
export default {
  components: {BarraNavegarReescrever},
  methods: {
    corrigirRedacao(){
      this.$router.push('/correcao-redacao')
    },
    retornar(){
      this.$router.go(-1);
    }
  }
}
</script>
<style scoped>
.lined-paper {
  position: relative;
  width: 100%;
  height: 720px;
  border: 1px solid #ccc;
  border-radius: 8px;
  overflow: hidden;
  margin-top: 40px;
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
      white 22px,
      #ccc 24px
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
  line-height: 24px;
  padding: 0 8px;
  outline: none;
  z-index: 1;
}
</style>