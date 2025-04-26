import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import axios from 'axios'
import { createVuetify } from 'vuetify'
import 'vuetify/styles' // Importa os estilos base do Vuetify
import { aliases, mdi } from 'vuetify/iconsets/mdi'
import router from './router'

const vuetify = createVuetify({
    icons: {
        defaultSet: 'mdi',
        aliases,
        sets: {
            mdi,
        },
    },
})

const app = createApp(App)
app.use(router)
app.use(vuetify)
app.config.globalProperties.$axios = axios

app.mount('#app')
