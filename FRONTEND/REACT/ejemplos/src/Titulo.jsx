export default function Titulo({ texto, nivel }) {
  const Etiqueta = `h${nivel}`;
  return <Etiqueta>{texto}</Etiqueta>;
}
