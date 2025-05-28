import { createRouter, createWebHistory } from 'vue-router'
import PaginaInicial from '@/pages/PaginaInicial.vue'
import CorrecaoRedacao from '@/pages/CorrecaoRedacao.vue'
import TelaRedacaoEscrita from '@/pages/TelaRedacaoEscrita.vue'

const routes = [
    { path: '/', component: PaginaInicial },
    { path: '/correcao-redacao', component: CorrecaoRedacao },
    { path: '/redacao', component: TelaRedacaoEscrita}
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router
