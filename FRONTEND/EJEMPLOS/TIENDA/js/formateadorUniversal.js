// formateadorUniversal.js

const PRESETS = {
  moneda: {
    style: "currency",
    currency: "EUR",
    minimumFractionDigits: 2,
    maximumFractionDigits: 2
  },
  porcentaje: {
    style: "percent",
    minimumFractionDigits: 0,
    maximumFractionDigits: 2
  },
  ui: {
    notation: "compact",
    compactDisplay: "short",
    minimumFractionDigits: 0,
    maximumFractionDigits: 1
  }
};

export function crearFormateadorUniversal(opcionesGlobales = {}) {
  return function formatear(valor, opcionesLocales = {}) {
    if (typeof valor !== "number" || Number.isNaN(valor)) {
      throw new Error("El valor debe ser un número válido");
    }

    const { preset } = opcionesLocales;

    const opciones = {
      ...opcionesGlobales,
      ...opcionesLocales,
      ...(preset ? PRESETS[preset] : {})
    };

    const {
      locale = "es-ES",
      style,
      currency,
      unit,
      unitDisplay = "short",
      notation = "standard",
      compactDisplay = "short",
      minimumFractionDigits,
      maximumFractionDigits,
      signDisplay
    } = opciones;

    return new Intl.NumberFormat(locale, {
      style,
      currency,
      unit,
      unitDisplay,
      notation,
      compactDisplay,
      minimumFractionDigits,
      maximumFractionDigits,
      signDisplay
    }).format(valor);
  };
}
