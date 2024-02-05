import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import Tabs from '@/views/Tabs.vue'
import Login from '@/views/Login.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    component: Login,
  },
  {
    path: '/tabs/',
    component: Tabs,
    children: [
      {
        path: '',
        redirect: '/tabs/tab1'
      },
      {
        path: 'todo',
        component: () => import('@/views/Todo.vue')
      },
      {
        path: 'projects',
        component: () => import('@/views/Projects.vue')
      },
      {
        path: 'timerecord',
        component: () => import('@/views/Timerecord.vue')
      },
      {
        path: 'status',
        component: () => import('@/views/Status.vue'),
      },
      {
        path: 'trainingseinheiten',
        component: () => import('@/views/Trainingseinheiten.vue'),
      },
      {
        path: 'oberkoerper',
        component: () => import('@/views/Oberkoerper.vue'),
      },
      {
        path: 'unterkoerper',
        component: () => import('@/views/Unterkoerper.vue'),
      }, 
    ]
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
