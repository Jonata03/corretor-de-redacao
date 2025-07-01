<template>
  <div>
    <barra-navegar-reescrever @retonarParaPaginaInicial="voltarParaTelaInicial"
                              @acaoBotaoPrincipal="reescreverRedacao"
                              @retornar = "acaoBotaoRetornar"
                              numero-pagina="3"
                              titulo-botao-principal="Reescrever"/>
    <v-container>
      <v-card class="ma-2 d-flex justify-center  align-center flex-column">
        <v-card-title>
          <h6>Nota Redação</h6>
        </v-card-title>
        <v-card-text class="pa-0">
          <h3><span class="pontuacao">1000</span>/1000</h3>
        </v-card-text>
        <v-card-actions>
          <botao-compartilhar @compartilhar="compartilhar"/>
        </v-card-actions>
      </v-card>
      <div class="d-flex flex-row flex-wrap justify-start">
        <competencia
            v-for="competencia in competencias"
            :key="competencia.titulo"
            :titulo="competencia.titulo"
            :corTitulo="competencia.corTitulo"
            :totalObtido="competencia.totalObtido"
            :totalMaximo="competencia.totalMaximo"
            class="ma-2"
            style="flex: 1 1 250px; max-width: 100%;"
        />
      </div>
      <v-card class="ma-2 d-flex justify-center  align-center flex-column">
        <v-container class="card pa-1">
          <button class="pa-1 mr-2 botoes">
            <v-icon color="yellow">mdi-star</v-icon>
            <span class="text-uppercase">  comentar</span>
          </button>
          <button @click="aplicarMarcador" class="pa-1 mr-2 botoes">
            <v-icon color="blue">mdi-marker</v-icon>
            <span class="text-uppercase"> destacar</span>
          </button>
          <button class="pa-1 mr-2 botoes" @click="desfazerUltimoMarcador">
            <v-icon color="red">mdi-backspace</v-icon>
            <span class="text-uppercase"> desmarcar</span>
          </button>
        </v-container>
        <div class="lined-paper">
          <div
              ref="texto"
              class="lined-textarea"
              contenteditable="true"
              @mouseup="handleSelection"
              style="min-height: 200px; white-space: pre-wrap;"
          ></div>
        </div>
      </v-card>
    </v-container>
  </div>
</template>
<script>
import BarraNavegarReescrever from '@/components/barraNevegacao/BarraNavegarReescrever.vue'
import BotaoCompartilhar from '@/components/BotaoCompartilhar.vue'
import Competencia from "@/components/cards/Competencia.vue";
import AreaTexto from "@/components/AreaTexto.vue";

export default {
  name: 'CorrecaoRedacao',
  components: {Competencia, BarraNavegarReescrever, BotaoCompartilhar, AreaTexto},
  data() {
    return {
      competencias: [{
        titulo: 'Competência 1',
        corTitulo: 'green',
        totalObtido: 200,
        totalMaximo: 200
      },
        {
          titulo: 'Competência 2',
          corTitulo: 'orange',
          totalObtido: 200,
          totalMaximo: 200
        },
        {
          titulo: 'Competência 3',
          corTitulo: 'red',
          totalObtido: 200,
          totalMaximo: 200
        },
        {
          titulo: 'Competência 4',
          corTitulo: 'blue',
          totalObtido: 200,
          totalMaximo: 200
        },
        {
          titulo: 'Competência 5',
          corTitulo: 'purple',
          totalObtido: 200,
          totalMaximo: 200
        }
      ],
      selectedRange: null,
      marcadores: []
    };
  },
  methods: {
    async reescreverRedacao(){
      await this.$router.push('/escrever');
    },
    async voltarParaTelaInicial() {
      await this.$router.push('/');
    },
    acaoBotaoRetornar(){
      this.$router.go(-1);
    },
    compartilhar() {
      console.log('Compartilhar a redação corrigida');
    },
    handleSelection() {
      const selection = window.getSelection();
      if (selection.rangeCount === 0) return;

      const range = selection.getRangeAt(0);

      if (this.$refs.texto.contains(range.commonAncestorContainer)) {
        this.selectedRange = range;
      } else {
        this.selectedRange = null;
      }
    },
    aplicarMarcador() {
      if (!this.selectedRange || this.selectedRange.collapsed) return;

      const span = document.createElement('span');
      span.style.backgroundColor = 'yellow';
      span.appendChild(this.selectedRange.extractContents());
      this.selectedRange.insertNode(span);

      this.marcadores.push(span); // <-- guarda o marcador

      this.selectedRange = null;
      window.getSelection().removeAllRanges();
    },
    desfazerUltimoMarcador() {
      const ultimo = this.marcadores.pop();
      if (!ultimo) return;

      const textoPuro = document.createTextNode(ultimo.textContent);
      ultimo.replaceWith(textoPuro);
    }
  }
}
</script>
<style scoped>
.botoes:hover {
  background-color: #e0e0e0;
  transition: 1s;
}

.pontuacao {
  font-size: 2em;
  font-weight: bold;
  color: #4CAF50;
}

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

.card {
  border-bottom: solid gray 1px;
}
</style>
