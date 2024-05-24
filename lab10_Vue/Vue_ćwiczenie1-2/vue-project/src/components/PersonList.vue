<template>
    <div>
      <h1>Person List</h1>
      <form @submit.prevent="addPerson">
        <label>
          First Name:
          <input v-model="firstName" />
        </label>
        <label>
          Last Name:
          <input v-model="lastName" />
        </label>
        <button type="submit">Add Person</button>
      </form>
      <ul>
        <li v-for="person in people" :key="person.id">{{ person.firstName }} {{ person.lastName }}</li>
      </ul>
      <p>Total number of people: {{ peopleCount }}</p>
    </div>
  </template>
  
  <script setup>
  import { ref, computed } from 'vue';
  
  const firstName = ref('');
  const lastName = ref('');
  const people = ref([]);
  
  const addPerson = () => {
    if (firstName.value && lastName.value) {
      people.value.push({ id: Date.now(), firstName: firstName.value, lastName: lastName.value });
      firstName.value = '';
      lastName.value = '';
    }
  };
  
  const peopleCount = computed(() => people.value.length);
  </script>
  
  <style scoped>
  form {
    margin-bottom: 1em;
  }
  </style>
  