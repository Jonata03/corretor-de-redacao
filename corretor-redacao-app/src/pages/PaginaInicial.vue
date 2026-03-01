<template>
  <v-container>
    <div class="d-flex justify-space-between align-center">
      <div>
        <h1 class="titulo-superior">Corretor de Redação</h1>
      </div>
      <div>
        <v-btn
            class="botao-escrever"
            color="white"
            rounded="xl"
            variant="plain"
            to="/escolher-tema">
          ESCREVER REDAÇÃO
        </v-btn>
      </div>
    </div>
    <span><h2 class="titulo-secao">Sumário</h2></span>
    <div class="d-flex">
      <v-card class="flex-grow-1 mr-5" rounded="xl">
        <v-card-item>
          <v-card-title class="texto-card">REDAÇÕES</v-card-title>
          <v-card-text class="texto-card-destacado pa-0">{{ redacaoQtd }}</v-card-text>
          <v-card-subtitle class="texto-card">redações corrigidas</v-card-subtitle>
        </v-card-item>
      </v-card>
      <v-card class="flex-grow-1 ml-5" rounded="xl">
        <v-card-item>
          <v-card-title class="texto-card">NOTA MÉDIA</v-card-title>
          <v-card-text class="texto-card-destacado pa-0">{{ notaMediaRedacoes() }}</v-card-text>
          <v-card-subtitle class="texto-card">pontos</v-card-subtitle>
        </v-card-item>
      </v-card>
    </div>
    <span><h2 class="titulo-secao">Rascunhos</h2></span>
    <div class="d-flex justify-space-between">
      <v-card class="flex-grow-1" rounded="xl">
        <v-card-item>
          <v-alert
              class="ma-2"
              color="green-lighten-4"
              icon="$info"
              theme="dark"
              :border="'start'"
              v-if="redacoes.length === 0"
          >
            Não há rascunhos
          </v-alert>
          <v-list v-else>
            <v-list-item v-for="(r, index) in rascunhos" :key="index" :value="r" color="primary" rounded="lg">
              <span class="texto-card">{{ r.titulo }}</span>
            </v-list-item>
          </v-list>
        </v-card-item>
      </v-card>
    </div>
  </v-container>
</template>
<script>
import axios from "axios";

export default {
  data() {
    return {
      redacoes: [],
      redacaoQtd: null,
      uri: import.meta.env.VITE_BACKEND
    }
  },
  mounted() {
     this.buscarRedacoes()
  },
  methods: {
    async buscarRedacoes() {
      const baseUrl = `${this.uri}/corretor-redacao/api`

      const resposta = await axios.get(`${this.uri}/redacao/buscar`)
      this.redacoes = resposta.data.redacoes
      this.redacaoQtd = this.redacoes.length

    },
    notaMediaRedacoes() {
      if (this.redacaoQtd === 0) return 0
      let media = 0;

      return media / this.redacaoQtd;
    },
  }
}
</script>
<style scoped>
.titulo-superior {
  font-size: 30px;
  font-weight: bold;
  text-shadow: 1px 1px 0 #999;
  color: #E65100;
}

.titulo-secao {
  font-size: 25px;
  font-weight: bold;
  text-shadow: 1px 1px 0 #999;
  margin-bottom: 10px;
  margin-top: 20px;
  color: #E65100;
}

.texto-card {
  font-size: 15px;
  color: #FF7043;
}

.texto-card-destacado {
  font-size: 30px;
  font-weight: bold;
  color: #E65100;
  padding: 16px 16px 16px 0;
}

.botao-escrever {
  background-color: #E65100;
}
</style>