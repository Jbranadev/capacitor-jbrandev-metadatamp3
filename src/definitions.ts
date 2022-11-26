import type { PermissionState } from "@capacitor/core";

export interface metadatamp3Plugin {
  
  /**
   * Retorna la meta data del archivo proporcionado
   * @param {File} file - Representación del archivo de audio del cual se obtendra la metadata 
   * @returns {MetaDataMp3} 
   */
  getMetadata(file:File):Promise<MetaDataMp3>;

  checkPermissions(): Promise<PermissionStatus>;

  requestPermissions(): Promise<PermissionStatus>;

}

/**
 * Definicion de File, Representa el file del cual se quiere obtener la metadata
 * @typedef {Object} File
 * @property {string} [name] - Nombre del archivo
 * @property {string} uri - Representa la uri hacía el archivo del cual se desea obtener la MetaData
 */
export interface File{
  /**
   * Nombre del archivo
   */
  name?:string;
  /**
   * Representa la uri hacía el archivo del cual se desea obtener la MetaData
   */
  uri:string;
}


/**
 * Definicion de MetaDataMp3 Representa toda la meta data obtenida del archivo por medio del pluggin
 * @typedef {Object} MetaDataMp3 
 * @property {MetaData} data - Array de metadatos obtenidos 
 */
export interface MetaDataMp3{
  /**
   * Array de metadatos obtenidos 
   */
  data:MetaData[];
}

/**
 * Definicion de MetaData Representa cada uno de los metadatos que se pueden obtener del pluggin
 * @typedef {Object} MetaData
 * @property {string} name - Nombre de la metadata obtenida
 * @property {string} value - Valor de la metadata obtenida
 */
export interface MetaData{
  /**
   * Nombre de la metadata obtenida
   */
  name:string;
  /**
   * Valor de la metadata obtenida
   */
  value:string;
}

/**
 * @interface PermissionStatus
 * Sirve para que el pluggin pueda identificar si la aplicación cuenta con los permisos requeridos
 * para el funcionamiento correcto de este.
 */
export interface PermissionStatus {
  // TODO: change 'location' to the actual name of your alias!
  location: PermissionState;
}