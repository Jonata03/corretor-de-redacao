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
          class="mb-4"
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
.step-wrapper {
  display: flex;
  align-items: center;
  flex-wrap: wrap;
  gap: 10px;
}

.lined-paper {
  position: relative;
  width: 100%;
  height: 750px;
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
      transparent,
      transparent 28px,
      #ccc 30px
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
  padding: 0 16px;
  outline: none;
  z-index: 1;
}
</style>