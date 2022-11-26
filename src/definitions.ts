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
 * @Interface
 * @File Representa el file del cual se quiere obtener la metadata
 * @property {string} name - Nombre del archivo de musica del cual se obtendra la metadata
 * @property {string} uri - Uri que representa la ubicación del archivo en el dispositivo 
 */
export interface File{
  name?:string;
  uri:string;
}


/**
 * @Interface
 * @MetaDataMP3 Representa toda la meta data obtenida del archivo por medio del pluggin
 * @property {MetaData} data - Array de metadatos obtenidos 
 */
export interface MetaDataMp3{
  data:MetaData[];
}

/**
 * @Interface
 * @MetaData Representa cada uno de los metadatos que se pueden obtener del pluggin
 * @property {string} name - Nombre de la metadata obtenida
 * @property {string} value - Valor de la metadata obtenida
 */
export interface MetaData{
  name:string;
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