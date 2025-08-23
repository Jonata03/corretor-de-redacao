import { createRouter, createWebHistory } from 'vue-router'
import PaginaInicial from '@/pages/PaginaInicial.vue'
import CorrecaoRedacao from '@/pages/CorrecaoRedacao.vue'
import EscreverRedacao from '@/pages/EscreverRedacao.vue'
import TemasRedacao from "@/pages/TemasRedacao.vue";

const routes = [
    { path: '/', component: PaginaInicial },
    { path: '/correcao-redacao/:idTema', component: CorrecaoRedacao },
    { path: '/escrever/:idTema', component: EscreverRedacao},
    { path: '/escolher-tema', component: TemasRedacao}
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router
