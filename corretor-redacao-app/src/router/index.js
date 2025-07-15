import { createRouter, createWebHistory } from 'vue-router'
import PaginaInicial from '@/pages/PaginaInicial.vue'
import CorrecaoRedacao from '@/pages/CorrecaoRedacao.vue'
import EscreverRedacao from '@/pages/EscreverRedacao.vue'

const routes = [
    { path: '/', component: PaginaInicial },
    { path: '/correcao-redacao', component: CorrecaoRedacao },
    { path: '/escrever', component: EscreverRedacao}
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router
