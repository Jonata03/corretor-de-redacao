import { createRouter, createWebHistory } from 'vue-router'
import tela2 from '@/components/tela2.vue'
import PaginaInicial from '@/pages/PaginaInicial.vue'
import CorrecaoRedacao from '@/pages/CorrecaoRedacao.vue'

const routes = [
    { path: '/', component: PaginaInicial },
    { path: '/correcao-redacao', component: CorrecaoRedacao },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router
