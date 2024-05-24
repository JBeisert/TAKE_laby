import { reactive } from 'vue';

const state = reactive({
  people: []
});

export const useStore = () => {
  const addPerson = (person) => {
    state.people.push(person);
  };

  return {
    people: state.people,
    addPerson
  };
};
