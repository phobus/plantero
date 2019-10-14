import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            name: 'home',
            title: 'Home',
            component: Home
        },
        {
            path: '/species',
            name: 'species',
            title: 'Species',
            component: () => import(/* webpackChunkName: "species" */ './views/Species.vue')
        },
        {
            path: '/about',
            name: 'about',
            title: 'About',
            component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
        }
    ]
})
