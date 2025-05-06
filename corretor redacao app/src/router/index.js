import { createRouter, createWebHistory } from 'vue-router'
import tela2 from '@/components/tela2.vue'
import PaginaInicial from "@/pages/PaginaInicial.vue";
import CorrecaoRedacao from "@/pages/CorrecaoRedacao.vue";

const routes = [
    { path: '/', component: PaginaInicial },
    { path: '/tela2', component: tela2 },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router
