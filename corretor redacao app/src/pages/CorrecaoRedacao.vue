<!--
<template>
  <v-container>
    <v-card class="pa-4" @mouseup="handleSelection">
      <div v-html="highlightedHtml"></div>
    </v-card>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      originalText: `Você pode marcar várias partes deste texto. Mesmo se ele repetir uma frase, você consegue destacar apenas onde quiser.mo se ele repetir uma frase, você consegue destacar apenas onde quiser.`,
      highlights: [], // Array de { start: Number, end: Number }
    };
  },
  computed: {
    highlightedHtml() {
      let result = '';
      let lastIndex = 0;

      // Ordena os trechos por início para evitar sobreposição fora de ordem
      const sortedHighlights = [...this.highlights].sort((a, b) => a.start - b.start);

      sortedHighlights.forEach(({ start, end }) => {
        // Adiciona o texto antes do destaque
        result += this.escapeHTML(this.originalText.slice(lastIndex, start));
        // Adiciona o trecho destacado
        result += `<span style="background-color: yellow;">${this.escapeHTML(this.originalText.slice(start, end))}</span>`;
        lastIndex = end;
      });

      // Adiciona o restante do texto após o último destaque
      result += this.escapeHTML(this.originalText.slice(lastIndex));

      return result;
    },
  },
  methods: {
    handleSelection() {
      const selection = window.getSelection();
      if (!selection.rangeCount) return;

      const range = selection.getRangeAt(0);
      const selectedText = selection.toString().trim();
      if (!selectedText) return;

      const container = range.commonAncestorContainer;
      if (!this.isPartOfText(container)) return;

      // Calcula o offset dentro do texto completo
      const preSelectionRange = range.cloneRange();
      preSelectionRange.selectNodeContents(this.$el.querySelector('div'));
      preSelectionRange.setEnd(range.startContainer, range.startOffset);
      const start = preSelectionRange.toString().length;
      const end = start + selectedText.length;

      // Evita duplicatas (por posição)
      if (!this.highlights.some(h => h.start === start && h.end === end)) {
        this.highlights.push({ start, end });
      }

      // Limpa a seleção para melhor UX
      selection.removeAllRanges();
    },
    isPartOfText(node) {
      return node.nodeType === Node.TEXT_NODE || (node.childNodes && [...node.childNodes].some(n => n.nodeType === Node.TEXT_NODE));
    },
    escapeHTML(str) {
      return str
          .replace(/&/g, '&amp;')
          .replace(/</g, '&lt;')
          .replace(/>/g, '&gt;');
    },
  },
};
</script>
-->


<template>
  <barra-navegar-reescrever/>
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
        <button class="pa-1 mr-2 ">
          <v-icon color="yellow">mdi-star</v-icon>
          <span class="text-uppercase">  comentar</span>
        </button>
        <button>
          <v-icon color="blue">mdi-marker</v-icon>
          <span class="text-uppercase"> demarcar</span>
        </button>
      </v-container>
      <div class="lined-paper">
      <textarea
          class="lined-textarea"
          placeholder="Escreva sua redação aqui..."
      ></textarea>
      </div>
    </v-card>
  </v-container>
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
      ]
    };
  },
  mounted() {
    this.$refs.modalAlert.show();
  },
  methods: {
    compartilhar() {
      console.log('Compartilhar a redação corrigida');
    },
  },
};
</script>
<style scoped>
.pontuacao {
  font-size: 2em;
  font-weight: bold;
  color: #4CAF50;
}
.lined-paper {
  position: relative;
  width: 100%;
  height: 550px;
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
      transparent 22px,
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
