<template>
    <div>
      <h1>List of Persons</h1>
      <ul>
        <li v-for="person in store.people" :key="person.id">{{ person.firstName }} {{ person.lastName }}</li>
      </ul>
      <p>Total number of people: {{ store.people.length }}</p>
    </div>
  </template>
  
  <script setup>
  import { useStore } from '../store';
  
  const store = useStore();
  </script>
  