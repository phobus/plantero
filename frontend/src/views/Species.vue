<template>
    <div class="species">
        <h1>This is an species page</h1>
        <species-list></species-list>
    </div>
</template>

<script>
    import SpeciesList from '@/components/SpeciesList.vue'

    export default {
        name: 'species',
        components: {
            SpeciesList
        }
    }
</script>
