<template>
  <div id="app">
    <navigation></navigation>
    <div class="container pt-3 pb-3">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
  import Navigation from './components/TheNavigation.vue'

  export default {
    name: 'app',
    components: {
      Navigation
    }
  }
</script>
