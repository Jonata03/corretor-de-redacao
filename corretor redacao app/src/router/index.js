import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/components/Home.vue'
import tela2 from '@/components/tela2.vue'
import CorrecaoRedacao from "@/pages/CorrecaoRedacao.vue";

const routes = [
    { path: '/', component: CorrecaoRedacao },
    { path: '/tela2', component: tela2 },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router
