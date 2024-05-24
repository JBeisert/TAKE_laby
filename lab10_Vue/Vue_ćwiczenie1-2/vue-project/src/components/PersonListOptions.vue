<template>
    <div>
      <h1>Person List (Options API)</h1>
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
  
  <script>
  export default {
    data() {
      return {
        firstName: '',
        lastName: '',
        people: []
      };
    },
    computed: {
      peopleCount() {
        return this.people.length;
      }
    },
    methods: {
      addPerson() {
        if (this.firstName && this.lastName) {
          this.people.push({ id: Date.now(), firstName: this.firstName, lastName: this.lastName });
          this.firstName = '';
          this.lastName = '';
        }
      }
    }
  };
  </script>
  
  <style scoped>
  form {
    margin-bottom: 1em;
  }
  </style>
  