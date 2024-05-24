<template>
    <div>
      <h1>New Person</h1>
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
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  import { useRouter } from 'vue-router';
  import { useStore } from '../store';
  
  const firstName = ref('');
  const lastName = ref('');
  const store = useStore();
  const router = useRouter();
  
  const addPerson = () => {
    if (firstName.value && lastName.value) {
      store.addPerson({ id: Date.now(), firstName: firstName.value, lastName: lastName.value });
      firstName.value = '';
      lastName.value = '';
      router.push('/list');
    }
  };
  </script>
  