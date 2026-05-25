const arr = Array(3);

arr[0] = 5;
arr[1] = 6;
arr[2] = 7;
arr[3] = 8;
arr[7] = 'texto';
arr[10] = 9;
arr['perro'] = 'dog';
arr.gato = 'cat';

arr.push(11);

console.log(arr['perro']);
console.log(arr.perro);
console.log(arr['gato']);

console.log(arr);

for (let i = 0; i < arr.length; i++) {
    console.log(arr[i]);
}

for (const clave in arr) {
    console.log(clave, arr[clave]);
}

for (const dato of arr) {
    console.log(dato);
}

console.log(typeof arr);