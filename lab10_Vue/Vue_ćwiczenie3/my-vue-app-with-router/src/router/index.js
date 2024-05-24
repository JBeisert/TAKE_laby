import { createRouter, createWebHistory } from 'vue-router';
import PersonForm from '../views/PersonForm.vue';
import PersonList from '../views/PersonList.vue';

const routes = [
  { path: '/', redirect: '/list' },
  { path: '/list', component: PersonList },
  { path: '/new', component: PersonForm }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
