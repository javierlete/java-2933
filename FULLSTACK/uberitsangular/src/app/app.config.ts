import { ApplicationConfig, DEFAULT_CURRENCY_CODE, LOCALE_ID, provideAppInitializer, provideBrowserGlobalErrorListeners } from '@angular/core';
import { provideRouter } from '@angular/router';
import { routes } from './app.routes';
import { registerLocaleData } from '@angular/common';
import localeEs from '@angular/common/locales/es';

registerLocaleData(localeEs);

export let apiUrl: string;

export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideRouter(routes),
    { provide: LOCALE_ID, useValue: 'es-ES' },
    { provide: DEFAULT_CURRENCY_CODE, useValue: 'EUR' },
    provideAppInitializer(async () => {
      const response = await fetch('/config.json');

      if (!response.ok) {
        throw new Error('Error cargando config.json');
      }

      const config = await response.json();
      apiUrl = config.apiUrl;
    })
  ],
};
