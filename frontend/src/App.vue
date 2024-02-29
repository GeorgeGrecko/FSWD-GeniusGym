<template>
  <ion-app>
    <ion-router-outlet />
  </ion-app>
</template>

<script setup lang="ts">
import { IonApp, IonRouterOutlet } from '@ionic/vue';
import { useStore } from './store';

useStore();


</script>

<!-- 
  Original von geniusgym:
  
  import { defineComponent, onMounted } from 'vue';
  <script setup lang="ts">
  import { IonApp, IonRouterOutlet } from '@ionic/vue';
</script>
-->
