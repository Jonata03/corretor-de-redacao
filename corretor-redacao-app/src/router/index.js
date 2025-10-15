import { createRouter, createWebHistory } from 'vue-router'
import PaginaInicial from '@/pages/PaginaInicial.vue'
import CorrecaoRedacao from '@/pages/CorrecaoRedacao.vue'
import EscreverRedacao from '@/pages/EscreverRedacao.vue'
import TemasRedacao from "@/pages/TemasRedacao.vue";
import TemasRedacaoEdicao from "@/pages/TemasRedacaoEdicao.vue";

const routes = [
    { path: '/', component: PaginaInicial },
    { path: '/correcao-redacao/:idRedacao', component: CorrecaoRedacao },
    { path: '/escrever/:idRedacao',
        name:'escrever',
        component: EscreverRedacao},
    { path: '/escolher-tema',
        name:'TemasRedacao',
        component: TemasRedacao},
    { path: '/editar-tema/:id',
        name:'TemasRedacaoEdicao',
        component: TemasRedacaoEdicao}
]

const router = createRouter({
    history: createWebHistory('/corretor-redacao/'),
    routes,
})

export default router
